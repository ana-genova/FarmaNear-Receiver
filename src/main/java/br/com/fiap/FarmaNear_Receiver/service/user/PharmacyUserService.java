package br.com.fiap.FarmaNear_Receiver.service.user;

import br.com.fiap.FarmaNear_Receiver.client.pharmacy.PharmacyService;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.request.CreateDrugstoreDTO;
import br.com.fiap.FarmaNear_Receiver.controller.dto.info.PharmacyUserInfoDTO;
import br.com.fiap.FarmaNear_Receiver.controller.dto.info.UserInfoDTO;
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
    public void createUserOnServices(UserInfoDTO userInfoDTO) {
        if (userInfoDTO instanceof PharmacyUserInfoDTO pharmacyUserInfoDTO) {
            CreateDrugstoreDTO createDrugstoreDTO = new CreateDrugstoreDTO(
                pharmacyUserInfoDTO.getCnpj(),
                pharmacyUserInfoDTO.getName(),
                pharmacyUserInfoDTO.getEmail(),
                pharmacyUserInfoDTO.getPhone(),
                pharmacyUserInfoDTO.getAddress()
            );

            pharmacyService.createDrugstore(createDrugstoreDTO);
            return;
        }

        throw new RuntimeException("Invalid User Info for Pharmacy");
    }
}
