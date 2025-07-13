package br.com.fiap.FarmaNear_Receiver.client.pharmacy.request;

public record PharmacyAddressDTO(String street, String number, String complement, String city, String state, String zipCode) {
}
