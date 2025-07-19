package br.com.fiap.FarmaNear_Receiver.client.pharmacy.request;

public record CreateDrugstoreDTO(String cnpj, String name, String email, String phone, PharmacyAddressDTO address) {
}
