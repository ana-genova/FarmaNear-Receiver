package br.com.fiap.FarmaNear_Receiver.controller.dto;

import br.com.fiap.FarmaNear_Receiver.model.RoleEnum;

public record UserDTO(String authToken, RoleEnum role) {
}
