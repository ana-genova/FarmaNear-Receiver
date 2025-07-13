package br.com.fiap.FarmaNear_Receiver.client.pharmacy.fallback;

import br.com.fiap.FarmaNear_Receiver.client.pharmacy.PharmacyService;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.request.CreateDrugstoreDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.DrugstoreDTO;
import org.springframework.stereotype.Component;

@Component
public class PharmacyServiceFallback implements PharmacyService {

    @Override
    public DrugstoreDTO createDrugstore(CreateDrugstoreDTO createDrugstoreDTO) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de farmácias");
    }

}
