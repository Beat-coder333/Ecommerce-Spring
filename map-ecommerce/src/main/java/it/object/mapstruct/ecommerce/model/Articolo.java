package it.object.mapstruct.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "articolo")

public class Articolo {

	@Id
	@SequenceGenerator(name = "articolo_sequence", sequenceName = "articolo_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articolo_sequence")
	@Column(name = "id_articolo")
	private Long id;

	@Column(name = "nome_articolo")
	private String articoloNome;

	@Column(name = "codice_articolo")
	private String articoloCode;

	@Column(name = "prezzo_unitario")
	private Integer prezzo;

	@Column(name = "disponibilita")
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
