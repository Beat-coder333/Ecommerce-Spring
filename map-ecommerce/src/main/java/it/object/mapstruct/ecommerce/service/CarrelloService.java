package it.object.mapstruct.ecommerce.service;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.object.mapstruct.ecommerce.dto.CarrelloDTO;
import it.object.mapstruct.ecommerce.mapper.CarrelloMapper;
import it.object.mapstruct.ecommerce.model.Carrello;
import it.object.mapstruct.ecommerce.repository.CarrelloRepository;

@Service
public class CarrelloService {

	@Autowired
	private CarrelloRepository cartRepo;

	@Autowired
	private CarrelloMapper cartMapper;

	public CarrelloDTO getCartId(Long idUser, HttpServletResponse response) {
		CarrelloDTO cartDto = null;
		Optional<Carrello> cart = cartRepo.findByUserId(idUser);
		if (cart.isPresent()) {
			cartDto = cartMapper.cartToDto(cart.get());
		} else {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			// crea nuovo carrello?
		}
		return cartDto;

	}

}
