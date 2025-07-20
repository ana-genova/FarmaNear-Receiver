package br.com.fiap.FarmaNear_Receiver.client.finder.request;

import br.com.fiap.FarmaNear_Receiver.controller.dto.LocationDto;

public record FinderCoordinatesReceiver(String medicine, LocationDto coordinates, int radius) {
}
