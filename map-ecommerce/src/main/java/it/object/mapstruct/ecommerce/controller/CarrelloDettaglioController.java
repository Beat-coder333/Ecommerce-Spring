package it.object.mapstruct.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.object.mapstruct.ecommerce.dto.CarrelloCompletoDTO;
import it.object.mapstruct.ecommerce.model.Utente;
import it.object.mapstruct.ecommerce.service.CarrelloDettaglioService;
import it.object.mapstruct.ecommerce.service.JWTService;

@RestController
@RequestMapping("/api/carrello-dettaglio")
public class CarrelloDettaglioController {

	private static Logger log = LoggerFactory.getLogger(CarrelloDettaglioController.class);

	@Autowired
	private CarrelloDettaglioService cartDetServ;

	@Autowired
	private JWTService jwtServ;

	@GetMapping("/cart-user")
	public ResponseEntity<CarrelloCompletoDTO> getByUserId(@RequestHeader("auth-token") String authToken) {
		log.info("CarrelloDettaglio Controlle - get carrello by Id Utente");

		Utente user = jwtServ.getUserByToken(authToken);
		CarrelloCompletoDTO cartComplDto = cartDetServ.findByUserId(user.getId());
		ResponseEntity<CarrelloCompletoDTO> resp = new ResponseEntity<>(cartComplDto, HttpStatus.OK);
		if (cartComplDto == null) {

			resp = new ResponseEntity<>(cartComplDto, HttpStatus.NO_CONTENT);
		}
		return resp;
	}

	@GetMapping("/list-carrello/{idCarrello}")

	@PostMapping("/insert-update/{quantita}/{idArticolo}")
	public void itemUpdateInsert(@PathVariable Integer quantita, @PathVariable Long idArticolo,
			@RequestHeader("auth-token") String authToken) {
		log.info("CarrelloDettaglioController - updete save Article");
		Utente user = jwtServ.getUserByToken(authToken);
		cartDetServ.updateInsertItem(user.getId(), idArticolo, quantita);
	}

	@DeleteMapping("/delete/{idArticolo}")
	public void deleteArticle(@PathVariable Long idArticolo, @RequestHeader("auth-token") String authToken) {
		log.info("CarrelloDettaglioController - deleteArticle");
		Utente user = jwtServ.getUserByToken(authToken);
		cartDetServ.deleteItem(user.getId(), idArticolo);
	}

}
