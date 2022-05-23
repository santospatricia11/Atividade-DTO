package dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import model.Produto;
@Component

public class ProdutoDTO {
	private long id;
	private String nomeProduto;
	private String tipo;

	public ProdutoDTO(Produto produto) {
		super();
		this.id = produto.getId();
		this.nomeProduto= produto.getNomeProduto();
		this.tipo= produto.getTipo();

	}

	public ProdutoDTO() {
			
		}

		/*
		 * @Bean public static List<ProdutoDTO> convert(List<Produto> produto) {
		 * 
		 * return produto.stream().map(ProdutoDTO::new).collect(Collectors.toList()); }
		 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
