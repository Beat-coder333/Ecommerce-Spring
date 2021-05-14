package it.object.mapstruct.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.object.mapstruct.ecommerce.model.CarrelloDettaglio;

@Repository
public interface CarrelloDettaglioRepository extends JpaRepository<CarrelloDettaglio, Long> {

	List<CarrelloDettaglio> findByCartId(Long idCarrello);

	public Optional<CarrelloDettaglio> findByCartIdAndArticoloId(Long idCarrello, Long idArticolo);

	@Modifying
	@Query(value = "INSERT INTO carrello_dettaglio(id_carrello,id_articolo, quantita) VALUES (?1 , ?2 ,?3) ", nativeQuery = true)
	@Transactional
	public void insertNewArticle(Long idCarrello, Long idArticolo, Integer quantita);

	@Modifying
	@Transactional
	@Query(value = "delete from CarrelloDettaglio cd where cd.cart.id = ?1 and cd.articolo.id = ?2")
	public void deleteArticolo(Long IdCarrello, Long idArticolo);

}
