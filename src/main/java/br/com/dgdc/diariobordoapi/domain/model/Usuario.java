package br.com.dgdc.diariobordoapi.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private long id;

	@NotBlank
	@Size(min = 2, max = 100)
	@Column(name = "nome_usuario")
	private String nome;

	@NotBlank
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{6,8}$", message = "Minimum 6 and Maximum 8 Character | Atleast 1 number | Atleast 1 alphabet in capitals. | No Special char allowed")
	@Column(name = "senha_usuario")
	private String senha;

	@NotBlank
	@Email(regexp = ".+@.+\\..+", message = "e-mail deve estar em um formato válido.")
	@Column(name = "email_usuario")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
