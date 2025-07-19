package br.com.fiap.FarmaNear_Receiver.controller;

import br.com.fiap.FarmaNear_Receiver.controller.dto.LoginDTO;
import br.com.fiap.FarmaNear_Receiver.model.RoleEnum;
import br.com.fiap.FarmaNear_Receiver.service.user.PatientUserService;
import br.com.fiap.FarmaNear_Receiver.service.user.PharmacyUserService;
import br.com.fiap.FarmaNear_Receiver.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Map<RoleEnum, UserService> userServiceMap;

    @Autowired
    public UserController(PatientUserService patientUserServiceService, PharmacyUserService pharmacyUserService) {
        userServiceMap = new HashMap<>();
        userServiceMap.put(RoleEnum.PATIENT, patientUserServiceService);
        userServiceMap.put(RoleEnum.PHARMACY, pharmacyUserService);
    }

    @PostMapping("/create")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        userServiceMap.get(loginDTO.role()).createUser(loginDTO);
        return ResponseEntity.ok().build();
    }

}
