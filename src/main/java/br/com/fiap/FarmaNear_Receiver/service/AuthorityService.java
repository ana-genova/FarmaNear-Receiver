package br.com.fiap.FarmaNear_Receiver.service;

import br.com.fiap.FarmaNear_Receiver.model.RoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    private static final String ROLE_PATIENT = "ROLE_PATIENT";
    private static final String ROLE_PHARMACY = "ROLE_PHARMACY";

    public GrantedAuthority getAuthority(RoleEnum role) {
        return switch (role) {
            case PATIENT -> new SimpleGrantedAuthority(ROLE_PATIENT);
            case PHARMACY -> new SimpleGrantedAuthority(ROLE_PHARMACY);
        };
    }

}
