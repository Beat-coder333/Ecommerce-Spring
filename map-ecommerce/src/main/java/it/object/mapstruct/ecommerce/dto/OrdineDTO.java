package it.object.mapstruct.ecommerce.dto;

import java.util.Date;
import java.util.List;

public class OrdineDTO {

	private Long id;
	private String numOrder;
	private Date data;
	private String username;
	private Long idUtente;
	private List<RigaOrdineDTO> orderListDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumOrder() {
		return numOrder;
	}

	public void setNumOrder(String numOrder) {
		this.numOrder = numOrder;
	}

	public String getUsername() {
		return username;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	public List<RigaOrdineDTO> getOrderListDto() {
		return orderListDto;
	}

	public void setOrderListDto(List<RigaOrdineDTO> orderListDto) {
		this.orderListDto = orderListDto;
	}
}
