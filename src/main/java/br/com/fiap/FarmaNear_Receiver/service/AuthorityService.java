package br.com.fiap.FarmaNear_Receiver.service;

import br.com.fiap.FarmaNear_Receiver.client.patient.PatientService;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.PharmacyService;
import br.com.fiap.FarmaNear_Receiver.exception.UserAuthorityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    private static final String ROLE_PATIENT = "ROLE_PATIENT";
    private static final String ROLE_PHARMACY = "ROLE_PHARMACY";

    private final PatientService patientService;
    private final PharmacyService pharmacyService;

    @Autowired
    public AuthorityService(PatientService patientService, PharmacyService pharmacyService) {
        this.patientService = patientService;
        this.pharmacyService = pharmacyService;
    }

    public GrantedAuthority getAuthority(Long userId) {
        if (patientService.isPatient(userId)) {
            return new SimpleGrantedAuthority(ROLE_PATIENT);
        }

        if (pharmacyService.isPharmacy(userId)) {
            return new SimpleGrantedAuthority(ROLE_PHARMACY);
        }

        throw new UserAuthorityException("User does not have a valid authority");
    }

}
