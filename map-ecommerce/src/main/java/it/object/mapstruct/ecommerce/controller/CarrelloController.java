package it.object.mapstruct.ecommerce.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.object.mapstruct.ecommerce.dto.CarrelloDTO;
import it.object.mapstruct.ecommerce.service.CarrelloService;

@RestController
@RequestMapping("/api/carrello")
public class CarrelloController {

	private static Logger log = LoggerFactory.getLogger(CarrelloController.class);

	@Autowired
	private CarrelloService cartServ;

	@GetMapping("/find/{idUtente}")
	public CarrelloDTO getIdCarrello(@PathVariable Long idUtente, HttpServletResponse response) {
		log.info("CarrelloController - getId");
		CarrelloDTO cartDto = cartServ.getCartId(idUtente, response);
		return cartDto;

	}
}
