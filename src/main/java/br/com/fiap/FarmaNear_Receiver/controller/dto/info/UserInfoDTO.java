package br.com.fiap.FarmaNear_Receiver.controller.dto.info;

public abstract class UserInfoDTO {

    private final String name;
    private final String email;
    private final String phone;

    public UserInfoDTO(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
