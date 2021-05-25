package it.object.mapstruct.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.object.mapstruct.ecommerce.dto.CarrelloCompletoDTO;
import it.object.mapstruct.ecommerce.mapper.CarrelloCompletoMapper;
import it.object.mapstruct.ecommerce.model.Articolo;
import it.object.mapstruct.ecommerce.model.Carrello;
import it.object.mapstruct.ecommerce.model.CarrelloDettaglio;
import it.object.mapstruct.ecommerce.repository.ArticoloRepository;
import it.object.mapstruct.ecommerce.repository.CarrelloDettaglioRepository;
import it.object.mapstruct.ecommerce.repository.CarrelloRepository;

@Service
public class CarrelloDettaglioService {

	@Autowired
	private CarrelloRepository cartRepo;

	@Autowired
	private ArticoloRepository itemRepo;

	@Autowired
	private CarrelloDettaglioRepository cartDetRepo;

	@Autowired
	CarrelloCompletoMapper cartComplMap;

	public CarrelloCompletoDTO findByUserId(Long IdUtente) {
		CarrelloCompletoDTO listCartDetails = cartComplMap.toDto(cartRepo.findByUserId(IdUtente));
		return listCartDetails;

	}

	public void updateInsertItem(Long idUtente, Long idArticolo, Integer quantita) {
		Carrello cart = cartRepo.findByUserId(idUtente);
		Optional<CarrelloDettaglio> cartDetOpt = cartDetRepo.findByCartIdAndArticoloId(cart.getId(), idArticolo);
		CarrelloDettaglio cartDet = null;
		if (cartDetOpt.isPresent()) {
			cartDet = cartDetOpt.get();
			cartDet.setQuantita(quantita);
			cartDetRepo.save(cartDet);
		} else {
			saveNewArticle(cart.getId(), idArticolo, quantita);

		}
	}

	public void saveNewArticle(Long idUtente, Long idArticolo, Integer quantita) {
		CarrelloDettaglio cartDet = new CarrelloDettaglio();
		Carrello cart = cartRepo.findByUserId(idUtente);
		Articolo item = itemRepo.findById(idArticolo).get();
		cartDet.setCart(cart);
		cartDet.setArticolo(item);
		cartDet.setQuantita(quantita);
		cartDetRepo.save(cartDet);

	}

	public void deleteItem(Long idUtente, Long idArticolo) {
		Carrello cart = cartRepo.findByUserId(idUtente);
		cartDetRepo.deleteByCartIdAndArticoloId(cart.getId(), idArticolo);
	}

}
