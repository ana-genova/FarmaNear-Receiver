package br.com.fiap.FarmaNear_Receiver.repository;

import br.com.fiap.FarmaNear_Receiver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByLogin(String login);
}
