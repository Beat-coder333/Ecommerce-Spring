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

@Entity
@Table(name = "ordine")
public class Ordine {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_ordine")
	private Long id;

	@Column(name = "numero_ordine")
	private String numOrder;

	@Column(name = "data_ordine")
	private String data;

	@OneToMany
	@JoinColumn(name = "id_ordine")
	private List<RigaOrdine> orderList;

	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente user;

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<RigaOrdine> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<RigaOrdine> orderList) {
		this.orderList = orderList;
	}

	public Utente getUser() {
		return user;
	}

	public void setUser(Utente user) {
		this.user = user;
	}
}
