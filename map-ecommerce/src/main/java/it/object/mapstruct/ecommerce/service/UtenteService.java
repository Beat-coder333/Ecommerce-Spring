package it.object.mapstruct.ecommerce.service;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.object.mapstruct.ecommerce.dto.LoginUtenteDTO;
import it.object.mapstruct.ecommerce.mapper.LoginUtenteMapper;
import it.object.mapstruct.ecommerce.model.Utente;
import it.object.mapstruct.ecommerce.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepo;

	@Autowired
	private LoginUtenteMapper loginUserMap;

	public LoginUtenteDTO chekUser(String name, String password, HttpServletResponse response) {

		LoginUtenteDTO loginUserDto = null;
		Optional<Utente> utente = utenteRepo.findByNomeUtenteAndPassword(name, password);
		if (utente.isPresent()) {
			loginUserDto = loginUserMap.usertToDto(utente.get());

		} else {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
		return loginUserDto;

	}
}
