package it.object.mapstruct.ecommerce.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.object.mapstruct.ecommerce.dto.LoginUtenteDTO;
import it.object.mapstruct.ecommerce.service.UtenteService;

@RestController
public class LoginController {

	@Autowired
	private UtenteService userServ;

	@PostMapping("/login")
	public LoginUtenteDTO chekUser(@RequestBody LoginUtenteDTO userDto, HttpServletResponse response) {
		LoginUtenteDTO loggedUser = userServ.chekUser(userDto.getUsername(), userDto.getPassword(), response);
		return loggedUser;

	}

}
