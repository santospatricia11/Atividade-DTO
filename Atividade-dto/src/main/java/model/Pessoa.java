package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Table(name = "pessoa")

@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	@NonNull
	@Column(name = "nome")
	private String nome;
	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "password")
	private String password;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	@Column(name = "cpf")
	private Long cpf;
	@NonNull
	@Column(name = "email")
	private String email;
	@NonNull
	@Column(name = "endereco")
	private String endereco;
	@NonNull
	@Column(name = "tipo")
	private String tipo;
	// um evento para muitos convidados
	@OneToMany
	private List<Produto> convidado;

	public Pessoa(String nome, String password, Long cpf, String email, String endereco, String tipo,
			List<Produto> convidado) {
		super();
		this.nome = nome;
		this.password = password;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;

		this.tipo = tipo;
		this.convidado = convidado;
	}

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
