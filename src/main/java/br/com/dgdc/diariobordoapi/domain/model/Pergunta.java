package br.com.dgdc.diariobordoapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pergunta")
public class Pergunta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pergunta")
	private Long id;

	@Column(name = "texto_resposta")
	private String texto;

	public Pergunta() {

	}

	public Pergunta(Long id, String texto) {
		super();
		this.id = id;
		this.texto = texto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
