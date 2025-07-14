package br.com.fiap.FarmaNear_Receiver.client.pharmacy.response;

import java.time.LocalDate;

public record GetProductDataDTO(String name, String brand, Integer quantity, String dosage, String type,
                                LocalDate expirationDate, String drugstoreCnpj, Double price) {
}
