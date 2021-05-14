package it.object.mapstruct.ecommerce.dto;

public class ArticoloDTO {

	private Long id;
	private String articoloNome;
	private String articoloCode;
	private Integer prezzo;
	private Integer disponibilita;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticoloNome() {
		return articoloNome;
	}

	public void setArticoloNome(String articoloNome) {
		this.articoloNome = articoloNome;
	}

	public String getArticoloCode() {
		return articoloCode;
	}

	public void setArticoloCode(String articoloCode) {
		this.articoloCode = articoloCode;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(Integer disponibilita) {
		this.disponibilita = disponibilita;
	}

}
