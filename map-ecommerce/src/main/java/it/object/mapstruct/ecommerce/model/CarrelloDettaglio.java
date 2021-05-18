package it.object.mapstruct.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carrello_dettaglio")
public class CarrelloDettaglio {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_carrello_dettaglio")
	private Long id;

	@Column(name = "quantita")
	private Integer quantita;

	@ManyToOne // non serve così
	@JoinColumn(name = "id_carrello")
	private Carrello cart;

	@ManyToOne
	@JoinColumn(name = "id_articolo")
	Articolo articolo;

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

	public Carrello getCart() {
		return cart;
	}

	public void setCart(Carrello cart) {
		this.cart = cart;
	}

	public Articolo getArticolo() {
		return articolo;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

}
