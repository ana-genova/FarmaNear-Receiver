package br.com.fiap.FarmaNear_Receiver.service.user;

import br.com.fiap.FarmaNear_Receiver.controller.dto.LoginDTO;
import br.com.fiap.FarmaNear_Receiver.controller.dto.info.UserInfoDTO;
import br.com.fiap.FarmaNear_Receiver.model.User;
import br.com.fiap.FarmaNear_Receiver.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public abstract class UserService {

    protected final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public abstract void createUserOnServices(UserInfoDTO userInfoDTO);

    @Transactional
    public void createUser(LoginDTO loginDTO) {
        validateFields(loginDTO);
        validateIfUserExists(loginDTO.login());

        User newUser = new User(loginDTO.login(), loginDTO.name(), encryptPassword(loginDTO.password()), loginDTO.role());
        userRepository.save(newUser);
    }

    public void finishUserCreation(UserInfoDTO userInfoDTO) {
        createUserOnServices(userInfoDTO);
    }

    private void validateFields(LoginDTO loginDTO) {
        if (StringUtils.isBlank(loginDTO.login())) {
            throw new RuntimeException("Invalid Login");
        }

        if (StringUtils.isBlank(loginDTO.password())) {
            throw new RuntimeException("Invalid Password");
        }
    }

    private void validateIfUserExists(String login) {
        Optional<User> user = userRepository.findByLogin(login);

        if (user.isPresent()) {
            throw new RuntimeException("User already exists");
        }
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
