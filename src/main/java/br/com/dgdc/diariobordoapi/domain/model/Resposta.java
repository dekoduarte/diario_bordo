package br.com.dgdc.diariobordoapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "resposta")
public class Resposta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_resposta")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "id_pergunta")
	private Pergunta pergunta;

	@NotNull
	@Column(name = "texto_resposta")
	private String texto;

	public Resposta() {
		super();
	}

	public Resposta(Long id, Pergunta pergunta, String texto) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.texto = texto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

}
