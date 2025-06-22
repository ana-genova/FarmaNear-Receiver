package br.com.fiap.FarmaNear_Receiver.client.patient.fallback;

import br.com.fiap.FarmaNear_Receiver.client.patient.PatientService;
import org.springframework.stereotype.Component;

@Component
public class PatientServiceFallback implements PatientService {

    @Override
    public boolean isPatient(long id) {
        //mock
        return id == 1L;
    }

}
