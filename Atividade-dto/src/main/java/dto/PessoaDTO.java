package dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import model.Pessoa;



public class PessoaDTO {
	private  String nome;
	private  String password;
	private Long cpf;
	private String email;
	private String endereco;
	private String tipo;

	
	public PessoaDTO(String nome,String password,Long cpf,String email,String endereco,String tipo) {
		super();
		this.nome=nome;
		this.password= password;
		this.cpf=cpf;
		this.email =email;
		this.endereco= endereco;
		this.tipo =tipo;
	}
	public PessoaDTO() {
		
	}

	/*
	 * public static List<PessoaDTO> convert(List<Pessoa> pessoa) {
	 * 
	 * 
	 * return pessoa; //.stream().map(PessoaDTO::new).collect(Collectors.toList());
	 * }
	 */

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
