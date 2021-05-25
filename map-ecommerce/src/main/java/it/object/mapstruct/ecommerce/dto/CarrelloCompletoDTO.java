package it.object.mapstruct.ecommerce.dto;

import java.util.List;

public class CarrelloCompletoDTO {

	private Long cartId;
	private List<CarrelloDettaglioDTO> cartListDto;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public List<CarrelloDettaglioDTO> getCartListDto() {
		return cartListDto;
	}

	public void setCartListDto(List<CarrelloDettaglioDTO> cartListDto) {
		this.cartListDto = cartListDto;
	}
}
