package it.object.mapstruct.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.object.mapstruct.ecommerce.dto.CarrelloDettaglioDTO;
import it.object.mapstruct.ecommerce.service.CarrelloDettaglioService;

@RestController
@RequestMapping("/api/carrello-dettaglio")
public class CarrelloDettaglioController {

	private static Logger log = LoggerFactory.getLogger(CarrelloDettaglioController.class);

	@Autowired
	private CarrelloDettaglioService cartDetServ;

	@GetMapping("/list-carrello/{idCarrello}")
	public List<CarrelloDettaglioDTO> getListCarrello(@PathVariable Long idCarrello) {
		log.info("CarrelloDettaglioController - findAll");
		List<CarrelloDettaglioDTO> listArticoli = cartDetServ.findListCarrello(idCarrello);
		return listArticoli;
	}

	@PostMapping("/delete/{idCarrello}/{idArticolo}")
	public void detleteFromCart(@PathVariable Long idArticolo, @PathVariable Long idCarrello) {
		log.info("CarrelloDettaglioController - deleteArticle");
		cartDetServ.deleteArticle(idCarrello, idArticolo);

	}

	@PostMapping("/insert-update/{quantita}/{idCarrello}/{idArticolo}")
	public void insertUpdate(@PathVariable Integer quantita, @PathVariable Long idArticolo,
			@PathVariable Long idCarrello) {
		log.info("CarrelloDettaglioController - saveArticle");
		cartDetServ.updateCart(idCarrello, idArticolo, quantita);
	}

}
