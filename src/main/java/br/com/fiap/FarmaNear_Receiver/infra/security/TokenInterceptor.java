package br.com.fiap.FarmaNear_Receiver.infra.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private final TokenService tokenService;

    public TokenInterceptor(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String oldToken = request.getHeader("Authorization");

        if (oldToken != null && oldToken.startsWith("Bearer ")) {
            String token = oldToken.replace("Bearer ", "");
            String subject = tokenService.getSubject(token);

            String newToken = tokenService.generateToken(subject);
            response.setHeader("Authorization", newToken);
        }

        return true;
    }

}
