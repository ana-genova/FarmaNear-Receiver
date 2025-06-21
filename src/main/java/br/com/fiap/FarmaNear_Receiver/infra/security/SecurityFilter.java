package br.com.fiap.FarmaNear_Receiver.infra.security;

import br.com.fiap.FarmaNear_Receiver.model.User;
import br.com.fiap.FarmaNear_Receiver.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  private static final String AUTHENTICATION_SCHEME = "Bearer ";

  @Autowired
  private TokenService tokenService;

  @Autowired
  private UserRepository userRepository;

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) {
    AntPathMatcher pathMatcher = new AntPathMatcher();
    List<String> excludeUrlPatterns = List.of(
        "/login",
        "/user/create"
    );

    return excludeUrlPatterns.stream().anyMatch(p -> pathMatcher.match(p, request.getServletPath()));
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String token = getAuthenticationToken(request);
    if (token != null) {
      String subject = tokenService.getSubject(token);
      User user = userRepository.findByLogin(subject).orElseThrow();
      var authentication = new UsernamePasswordAuthenticationToken(user, null, null);
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    filterChain.doFilter(request, response);
  }

  private String getAuthenticationToken(HttpServletRequest request) {
    String authorizationHeader = request.getHeader("Authorization");
    if (authorizationHeader != null) {
      return authorizationHeader.replace(AUTHENTICATION_SCHEME, "");
    }
    return null;
  }
}

