package br.com.fiap.FarmaNear_Receiver.client.pharmacy.response;

import br.com.fiap.FarmaNear_Receiver.client.pharmacy.request.PharmacyAddressDTO;

public record DrugstoreDTO(String cnpj, String name, String email, String phone, PharmacyAddressDTO address) {
}
