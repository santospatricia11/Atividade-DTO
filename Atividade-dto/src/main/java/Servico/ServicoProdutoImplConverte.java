package Servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dto.PessoaDTO;
import dto.ProdutoDTO;
import model.Pessoa;
import model.Produto;

public class ServicoProdutoImplConverte implements ServicoProdutoConverte {

	@Override
	public List<ProdutoDTO> produtoToDTOList(List<ProdutoDTO> entities) {
		List<ProdutoDTO> dtos = new ArrayList<>();

		for (ProdutoDTO dto : entities) {
			ProdutoDTO entity = produtoToDTO(dto);
			dtos.add(entity);
		}
		return dtos;
	}

	@Override
	public ProdutoDTO dtoProduto(ProdutoDTO dto) {
		Produto entity = new Produto();
		entity.setNomeProduto(dto.getNomeProduto());
		entity.setId(dto.getId());

		entity.setTipo(dto.getTipo());

		return dto;
	}

	@Override
	public ProdutoDTO produtoToDTO(ProdutoDTO entity) {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setNomeProduto(entity.getNomeProduto());
		dto.setId(entity.getId());
		dto.setTipo(entity.getTipo());

		return dto;
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	public Optional<Produto> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
