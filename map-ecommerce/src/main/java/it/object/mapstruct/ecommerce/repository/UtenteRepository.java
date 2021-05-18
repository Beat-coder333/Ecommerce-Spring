package it.object.mapstruct.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.object.mapstruct.ecommerce.model.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Optional<Utente> findByNomeUtenteAndPassword(String username, String password);
}
