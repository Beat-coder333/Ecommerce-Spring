package it.object.mapstruct.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.object.mapstruct.ecommerce.model.Carrello;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {

	public Optional<Carrello> findByUserId(Long userId);

}
