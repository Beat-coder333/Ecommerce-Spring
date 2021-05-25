package it.object.mapstruct.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carrello")
public class Carrello {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrello")
	@Id
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente user;

	@JsonIgnore
	@OneToMany
	private List<CarrelloDettaglio> cartDetailsList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUser() {
		return user;
	}

	public void setUser(Utente user) {
		this.user = user;
	}

	public List<CarrelloDettaglio> getCartDetailsList() {
		return cartDetailsList;
	}

	public void setCartDetailsList(List<CarrelloDettaglio> cartDetailsList) {
		this.cartDetailsList = cartDetailsList;
	}

}
