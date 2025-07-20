package br.com.fiap.FarmaNear_Receiver.client.pharmacy.request;

public record CreateDrugstoreRequest(String cnpj, String name, String email, String phone, String street, String neighborhood,
                                     String city, String number, String state, String zipCode) {
}
