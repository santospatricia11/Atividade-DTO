package Servico;

import java.util.List;

import dto.PessoaDTO;
import model.Pessoa;



public interface PessoaSevicoConverte {
	public List<PessoaDTO> pessoaToDTOList(List<PessoaDTO> entities);
	public Pessoa dtoToPessoa(PessoaDTO dto);
	public PessoaDTO pessoaToDTO(Pessoa entity);

}
