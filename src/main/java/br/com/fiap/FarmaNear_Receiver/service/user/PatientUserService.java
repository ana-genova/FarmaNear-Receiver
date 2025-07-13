package br.com.fiap.FarmaNear_Receiver.service.user;

import br.com.fiap.FarmaNear_Receiver.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientUserService extends UserService {

    public PatientUserService(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public void createUserOnServices() {

    }


}
