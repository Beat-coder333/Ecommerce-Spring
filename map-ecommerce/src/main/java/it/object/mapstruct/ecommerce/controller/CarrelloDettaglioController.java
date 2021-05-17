package it.object.mapstruct.ecommerce.controller;

import java.util.List;

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

	@Autowired
	private CarrelloDettaglioService cartDetServ;

	@GetMapping("/list-carrello/{idCarrello}")
	public List<CarrelloDettaglioDTO> getListCarrello(@PathVariable Long idCarrello) {
		List<CarrelloDettaglioDTO> listArticoli = cartDetServ.findListCarrello(idCarrello);
		return listArticoli;
	}

	@PostMapping("/delete/{idCarrello}/{idArticolo}")
	public void detleteFromCart(@PathVariable Long idArticolo, @PathVariable Long idCarrello) {
		cartDetServ.deleteArticle(idCarrello, idArticolo);

	}

	@PostMapping("/insert-update/{quantita}/{idCarrello}/{idArticolo}")
	public void insertUpdate(@PathVariable Integer quantita, @PathVariable Long idArticolo,
			@PathVariable Long idCarrello) {
		cartDetServ.updateCart(idCarrello, idArticolo, quantita);
	}

//	@PutMapping("/save")
//	public CarrelloDettaglioDTO save(@RequestBody() CarrelloDettaglioDTO cartDetDto) {
//		return cartDetServ.NON ESISTE(cartDetDto);
//
//	}

}
