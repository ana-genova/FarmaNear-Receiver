package br.com.fiap.FarmaNear_Receiver.service.user;

import br.com.fiap.FarmaNear_Receiver.client.pharmacy.PharmacyService;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.request.CreateDrugstoreDTO;
import br.com.fiap.FarmaNear_Receiver.controller.dto.LoginDTO;
import br.com.fiap.FarmaNear_Receiver.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PharmacyUserService extends UserService {

    private final PharmacyService pharmacyService;

    public PharmacyUserService(UserRepository userRepository, PharmacyService pharmacyService) {
        super(userRepository);

        this.pharmacyService = pharmacyService;
    }

    @Override
    public void createUserOnServices() {
    }


}
