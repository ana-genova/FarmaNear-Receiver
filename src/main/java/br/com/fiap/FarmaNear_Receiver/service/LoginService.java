package br.com.fiap.FarmaNear_Receiver.service;

import br.com.fiap.FarmaNear_Receiver.controller.dto.LoginDTO;
import br.com.fiap.FarmaNear_Receiver.infra.security.TokenService;
import br.com.fiap.FarmaNear_Receiver.model.User;
import br.com.fiap.FarmaNear_Receiver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Autowired
    public LoginService(TokenService tokenService, UserRepository userRepository) {
        this.encoder = new BCryptPasswordEncoder();
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    public String login(LoginDTO loginDTO) {
        Optional<User> user = userRepository.findByLogin(loginDTO.login());
        validateLogin(user, loginDTO.password());
        return tokenService.generateToken(loginDTO.login());
    }

    private void validateLogin(Optional<User> user, String inputPassword) {
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        if (!encoder.matches(inputPassword, user.get().getPassword())) {
            throw new RuntimeException("Wrong password");
        }
    }


}
