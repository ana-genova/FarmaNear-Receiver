package br.com.fiap.FarmaNear_Receiver.service;

import br.com.fiap.FarmaNear_Receiver.controller.dto.LoginDTO;
import br.com.fiap.FarmaNear_Receiver.model.User;
import br.com.fiap.FarmaNear_Receiver.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void createUser(LoginDTO loginDTO) {
        validateFields(loginDTO);

        validateIfUserExists(loginDTO.login());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(loginDTO.password());
        User newUser = new User(loginDTO.login(), encryptedPassword, loginDTO.role());

        userRepository.save(newUser);
    }

    private void validateIfUserExists(String login) {
        Optional<User> user = userRepository.findByLogin(login);

        if (user.isPresent()) {
            throw new RuntimeException("User already exists");
        }
    }

    private void validateFields(LoginDTO loginDTO) {
        if (StringUtils.isBlank(loginDTO.login())) {
            throw new RuntimeException("Invalid Login");
        }

        if (StringUtils.isBlank(loginDTO.password())) {
            throw new RuntimeException("Invalid Password");
        }
    }
}
