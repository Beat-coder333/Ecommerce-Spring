package it.object.mapstruct.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.object.mapstruct.ecommerce.dto.LoginUtenteDTO;
import it.object.mapstruct.ecommerce.model.Utente;
import it.object.mapstruct.ecommerce.service.JWTService;
import it.object.mapstruct.ecommerce.service.UtenteService;

@RestController
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private JWTService jwtServ;

	@Autowired
	private UtenteService userServ;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginUtenteDTO loggedUserDto) throws Exception {

		log.info("LoginController - login");

		ResponseEntity<String> resp = null;
		if (loggedUserDto == null) {
			resp = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} else {
			Utente user = userServ.userLogin(loggedUserDto);

			if (user == null) {
				resp = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
			} else {
				log.info("login - user logged in ");
				String token = jwtServ.createJWTToken(user);
				resp = new ResponseEntity<String>(token, HttpStatus.OK);
			}
		}

		return resp;

	}

}
