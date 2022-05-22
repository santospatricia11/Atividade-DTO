package dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import model.Pessoa;



public class PessoaDTO {
	private  String nome;
	@Column(name = "comment_cpf")
	private Long cpf;
	private String email;
	private  String password;


	private String endereco;
	private String tipo;

	
	public PessoaDTO(Pessoa pessoa) {
		super();
		this.nome=pessoa.getNome();
		this.password= pessoa.getPassword();
		this.cpf=pessoa.getCpf();
		this.email =pessoa.getEmail();
		this.endereco= pessoa.getEndereco();
		this.tipo =pessoa.getTipo();
		
	}
	public PessoaDTO() {
		
	}

	@Bean
	public static List<PessoaDTO> convert(List<Pessoa> pessoa) {
		
		
		return pessoa.stream().map(PessoaDTO::new).collect(Collectors.toList());
	}

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
