package br.com.fiap.FarmaNear_Receiver.client.pharmacy.fallback;

import br.com.fiap.FarmaNear_Receiver.client.pharmacy.PharmacyService;
import org.springframework.stereotype.Component;

@Component
public class PharmacyServiceFallback implements PharmacyService {

    @Override
    public boolean isPharmacy(long id) {
        // mock
        return id == 2L; // Example fallback behavior
    }

}
