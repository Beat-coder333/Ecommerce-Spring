package it.object.mapstruct.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.object.mapstruct.ecommerce.dto.CarrelloDettaglioDTO;
import it.object.mapstruct.ecommerce.mapper.CarrelloDettaglioMapper;
import it.object.mapstruct.ecommerce.model.CarrelloDettaglio;
import it.object.mapstruct.ecommerce.repository.CarrelloDettaglioRepository;

@Service
public class CarrelloDettaglioService {

	@Autowired
	private CarrelloDettaglioRepository cartDetRepo;

	@Autowired
	private CarrelloDettaglioMapper cartDetMap;

	public List<CarrelloDettaglioDTO> findListCarrello(Long idCarrello) {
		List<CarrelloDettaglioDTO> cartDetDto = null;
		List<CarrelloDettaglio> listCart = cartDetRepo.findByCartId(idCarrello);
		cartDetDto = cartDetMap.cartDetToDto(listCart);

		return cartDetDto;

	}

	public void updateCart(Long idCarrello, Long idArticolo, Integer quantita) {
		Optional<CarrelloDettaglio> cartDetOpt = cartDetRepo.findByCartIdAndArticoloId(idCarrello, idArticolo);
		CarrelloDettaglio cartDet = null;
		if (cartDetOpt.isPresent()) {
			cartDet = cartDetOpt.get();
			cartDet.setQuantita(quantita);
			cartDetRepo.save(cartDet);
		} else {
			insertArticle(idCarrello, idArticolo, quantita);

		}
	}

	public void insertArticle(Long idCarrello, Long idArticolo, Integer quantita) {
		cartDetRepo.insertNewArticle(idCarrello, idArticolo, quantita);

	}

	public void deleteArticle(Long idCarrello, Long idArticolo) {
		cartDetRepo.deleteArticolo(idCarrello, idArticolo);

	}

}
