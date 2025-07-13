package br.com.fiap.FarmaNear_Receiver.client.pharmacy;

import br.com.fiap.FarmaNear_Receiver.client.pharmacy.fallback.PharmacyServiceFallback;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.request.CreateDrugstoreDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.DrugstoreDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "PharmacyService",
        url = "${pharmacy.service.url}",
        fallback = PharmacyServiceFallback.class)
public interface PharmacyService {

    @PostMapping("/register/drugstore")
    DrugstoreDTO createDrugstore(CreateDrugstoreDTO createDrugstoreDTO);

}
