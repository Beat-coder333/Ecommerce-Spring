package it.object.mapstruct.ecommerce.dto;

import it.object.mapstruct.ecommerce.model.Articolo;

public class CarrelloDettaglioDTO {

	private Long id;
	private Integer quantita;
	private Long idCarrello;// -
	private Long idArticolo;// articolo article
	private Articolo article;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public Long getIdCarrello() {
		return idCarrello;
	}

	public void setIdCarrello(Long idCarrello) {
		this.idCarrello = idCarrello;
	}

	public Long getIdArticolo() {
		return idArticolo;
	}

	public void setIdArticolo(Long idArticolo) {
		this.idArticolo = idArticolo;
	}

	public Articolo getArticle() {
		return article;
	}

	public void setArticle(Articolo article) {
		this.article = article;
	}

}
