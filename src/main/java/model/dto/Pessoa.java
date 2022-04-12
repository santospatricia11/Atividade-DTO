package model.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cpf;
	private String email;
	private String endereco;
	private String tipo;
	//um evento para muitos convidados
	@OneToMany
	private List<Produto> convidado;

	public Pessoa(String nome, Long cpf, String email, String endereco, String tipo, List<Produto> convidado) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.tipo = tipo;
		this.convidado = convidado;
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
	


}
