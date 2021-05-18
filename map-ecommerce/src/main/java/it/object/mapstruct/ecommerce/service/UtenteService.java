package it.object.mapstruct.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.object.mapstruct.ecommerce.dto.LoginUtenteDTO;
import it.object.mapstruct.ecommerce.model.Utente;
import it.object.mapstruct.ecommerce.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepo;

//con mapper	
//	@Autowired 
//	private LoginUtenteMapper loginUserMap;

//	public LoginUtenteDTO getUser(String username, String password) {
//		LoginUtenteDTO loginUserDto = null;
//		Optional<Utente> utente = utenteRepo.findByNomeUtenteAndPassword(username, password);
//		if (utente.isPresent()) {
//			loginUserDto = loginUserMap.usertToDto(utente.get());
//
//		}
//		return loginUserDto;
//
//	}

	public Utente userLogin(LoginUtenteDTO loginUserDto) {
		Utente user = null;
		String username = loginUserDto.getUsername();
		String password = loginUserDto.getPassword();
		Optional<Utente> utente = utenteRepo.findByNomeUtenteAndPassword(username, password);
		if (utente.isPresent()) {
			user = utente.get();
		}
		return user;

	}
}
