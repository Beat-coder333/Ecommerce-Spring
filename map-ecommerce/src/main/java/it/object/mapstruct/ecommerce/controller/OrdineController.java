package it.object.mapstruct.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.object.mapstruct.ecommerce.dto.OrdineDTO;
import it.object.mapstruct.ecommerce.model.Utente;
import it.object.mapstruct.ecommerce.service.JWTService;
import it.object.mapstruct.ecommerce.service.OrdineService;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController {

	private static Logger log = LoggerFactory.getLogger(OrdineController.class);

	@Autowired
	private OrdineService orderServ;

	@Autowired
	private JWTService jwtServ;

	@GetMapping("/get-order")
	public ResponseEntity<List<OrdineDTO>> getOrderByUserId(@RequestHeader("auth-token") String authToken) {
		log.info("OrdineController - get ordine");
		Utente user = jwtServ.getUserByToken(authToken);
		List<OrdineDTO> ordersList = orderServ.getOrdersByIdUser(user.getId());
		ResponseEntity<List<OrdineDTO>> resp = new ResponseEntity<>(ordersList, HttpStatus.OK);
		if (ordersList.isEmpty()) {
			resp = new ResponseEntity<>(ordersList, HttpStatus.NO_CONTENT);
		}
		return resp;

	}

	@PostMapping("/insert-update")
	public void insertOrder(@RequestParam String numOrder, @RequestHeader("auth-token") String authToken) {
		log.info("OrdineController - insert order");
		Utente user = jwtServ.getUserByToken(authToken);
		orderServ.saveOrder(numOrder, user.getId());

	}

}
