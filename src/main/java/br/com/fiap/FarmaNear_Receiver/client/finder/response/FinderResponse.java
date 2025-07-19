package br.com.fiap.FarmaNear_Receiver.client.finder.response;

import br.com.fiap.FarmaNear_Receiver.controller.dto.LocationDto;

public record FinderResponse(String id, String name, LocationDto coordinates) {
}
