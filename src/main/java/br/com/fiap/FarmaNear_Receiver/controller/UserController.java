package br.com.fiap.FarmaNear_Receiver.controller;

import br.com.fiap.FarmaNear_Receiver.controller.dto.LoginDTO;
import br.com.fiap.FarmaNear_Receiver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        userService.createUser(loginDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }
}
