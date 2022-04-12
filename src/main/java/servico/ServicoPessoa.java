package servico;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import model.dto.Pessoa;
import repository.PessoaRepository;

@Service
public class ServicoPessoa {
	@Autowired
	private PessoaRepository pessoaR;
	
	public Pessoa save(Pessoa pessoa) {
		return pessoaR.save(pessoa);
	}

	public Pessoa deleteById(long cpf) {
		return null;
	}

	public Optional<Pessoa> findById(long cpf) {
		return Optional.of(pessoaR.findById((long) cpf).get());
	}

	public List<Pessoa> findAll() {
		return (List<Pessoa>) pessoaR.findAll();
	}

	public Pessoa update(long cpf, Pessoa pessoa) {
		return pessoaR.save(pessoa);
	}
	
	public List<Pessoa> findAllByTipoDestino(String pessoa, Pageable pageable) {
		return (List<Pessoa>) pessoaR.findAll(pageable);
	}

}
