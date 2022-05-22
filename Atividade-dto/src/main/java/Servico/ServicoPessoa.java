package Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import RestRepositoty.PessoaRepository;
import model.Pessoa;

@Service


public class ServicoPessoa {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public void deleteById(Long cpf) {
		
		Pessoa pessoa = findById(cpf);
				//findById(cpf);
		
		if(pessoa== null) {
			throw new IllegalStateException(String.format("Could not find a entity with id=%1", cpf));
		}
		
		pessoaRepository.deleteById(cpf);
	}

	public Pessoa update(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa update(Long cpf) {
		
		Pessoa pessoaSalvo = pessoaRepository.getById(cpf);
		if(cpf == null) {
			throw new IllegalStateException("CPF cannot be null");
		}		
		return pessoaRepository.save(pessoaSalvo);
	}
	
	public Pessoa findById(Long cpf) {
		if(cpf == null) {
			throw new IllegalStateException("cpf cannot be null");
		}
		return pessoaRepository.findById(cpf).get();
	}

	public Iterable<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
	
	public List<Pessoa> find(Pessoa filter) {
		Example example = Example.of(filter, ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		
		return pessoaRepository.findAll(example);
		
	}

}
