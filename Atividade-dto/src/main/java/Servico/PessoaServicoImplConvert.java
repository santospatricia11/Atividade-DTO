package Servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import dto.PessoaDTO;
import dto.ProdutoDTO;
import model.Pessoa;


public class PessoaServicoImplConvert implements PessoaSevicoConverte {
	@ Autowired
	private PessoaServicoImplConvert pessoaServicoImplConvert;
	@Autowired
	private ServicoPessoa servicoPessoa;
	
	@Override
	public List<PessoaDTO> pessoaToDTOList(List<PessoaDTO> entities) {
		List<PessoaDTO> dtos = new ArrayList<>();

		for (PessoaDTO dto : entities) {
			PessoaDTO entity = pessoaToDTO(dto);
			dtos.add(entity);
		}
		return dtos;

	}

	@Override
	public Pessoa dtoToPessoa(PessoaDTO dto) {
		Pessoa entity = new Pessoa();
		entity.setNome(dto.getNome());

		entity.setCpf(((PessoaDTO) dto).getCpf());

		return entity;
	}

	@Override
	public PessoaDTO pessoaToDTO(PessoaDTO entity) {
		PessoaDTO dto = new PessoaDTO();
		dto.setNome(entity.getNome());
		dto.setCpf(entity.getCpf());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		

		return dto;
	}

}
