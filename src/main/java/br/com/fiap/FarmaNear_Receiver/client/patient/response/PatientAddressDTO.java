package br.com.fiap.FarmaNear_Receiver.client.patient.response;

public record PatientAddressDTO(Long id, String street, String number, String neighborhood, String complement,
                                String city, String state, String zipCode, String mobilePhone, String email,
                                Long idPatient) {
}
