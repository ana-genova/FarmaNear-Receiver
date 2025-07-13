package br.com.fiap.FarmaNear_Receiver.controller.dto;

import br.com.fiap.FarmaNear_Receiver.model.RoleEnum;

public record LoginDTO(String login, String password, String name, RoleEnum role) {
}
