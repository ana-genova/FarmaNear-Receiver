package br.com.fiap.FarmaNear_Receiver.service;

import br.com.fiap.FarmaNear_Receiver.controller.dto.LoginDTO;
import br.com.fiap.FarmaNear_Receiver.model.User;
import br.com.fiap.FarmaNear_Receiver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  @Autowired
  private UserRepository userRepository;

  public void login(LoginDTO loginDTO) {
    Optional<User> user = userRepository.findByLogin(loginDTO.login());
    if (user.isEmpty()) {
      throw new RuntimeException("User not found");
    }
    if (!encoder.matches(loginDTO.password(), user.get().getPassword())) {
      throw new RuntimeException("Wrong password");
    }
  }
}
