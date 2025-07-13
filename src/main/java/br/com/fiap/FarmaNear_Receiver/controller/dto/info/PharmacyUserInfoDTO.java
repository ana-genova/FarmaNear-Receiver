package br.com.fiap.FarmaNear_Receiver.controller.dto.info;

import br.com.fiap.FarmaNear_Receiver.client.pharmacy.request.PharmacyAddressDTO;

public class PharmacyUserInfoDTO extends UserInfoDTO {

    private final String cnpj;
    private final PharmacyAddressDTO address;

    public PharmacyUserInfoDTO(String cnpj, String name, String email, String phone, PharmacyAddressDTO address) {
        super(name, email, phone);

        this.cnpj = cnpj;
        this.address = address;
    }

    public String getCnpj() {
        return cnpj;
    }

    public PharmacyAddressDTO getAddress() {
        return address;
    }
}
