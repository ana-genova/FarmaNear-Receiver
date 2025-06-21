package br.com.fiap.FarmaNear_Receiver.controller;

import br.com.fiap.FarmaNear_Receiver.controller.dto.LoginDTO;
import br.com.fiap.FarmaNear_Receiver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private LoginService loginService;

  @PostMapping()
  public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
    loginService.login(loginDTO);
    return ResponseEntity.ok().build();
  }
}
