package it.object.mapstruct.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "riga_ordine")
public class RigaOrdine {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_riga_ordine")
	@Id
	private Long id;

	@Column(name = "id_ordine")
	private Long orderId;

	@Column(name = "quantita")
	private Integer quantity;

	@OneToOne
	@JoinColumn(name = "id_articolo")
	private Articolo article;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Articolo getArticle() {
		return article;
	}

	public void setArticle(Articolo article) {
		this.article = article;
	}

}
