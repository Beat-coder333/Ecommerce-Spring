package it.object.mapstruct.ecommerce.dto;

public class RigaOrdineDTO {

	private Long id;
	private Long idOrdine;
	private Integer quantita;
	private ArticoloDTO articleDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(Long idOrdine) {
		this.idOrdine = idOrdine;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public ArticoloDTO getArticleDto() {
		return articleDto;
	}

	public void setArticleDto(ArticoloDTO articleDto) {
		this.articleDto = articleDto;
	}
}
