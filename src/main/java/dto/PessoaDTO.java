package dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import model.dto.Pessoa;

@Component
public class PessoaDTO {
	private Long cpf;
	private String email;
	private String endereco;
	private String tipo;

	
	public PessoaDTO(Pessoa pessoa) {
		super();
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
