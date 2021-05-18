package it.object.mapstruct.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import it.object.mapstruct.ecommerce.model.CarrelloDettaglio;

@Repository
public interface CarrelloDettaglioRepository extends JpaRepository<CarrelloDettaglio, Long> {

	List<CarrelloDettaglio> findByCartId(Long idCarrello);

	public Optional<CarrelloDettaglio> findByCartIdAndArticoloId(Long idCarrello, Long idArticolo);

	@Modifying(clearAutomatically = true)
	@Transactional
	void deleteByCartIdAndArticoloId(Long idCarrello, Long idArticolo);

}
