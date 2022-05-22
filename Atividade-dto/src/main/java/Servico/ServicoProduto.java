package Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import RestRepositoty.PessoaRepository;
import RestRepositoty.ProdutoRepository;
import model.Pessoa;
import model.Produto;

@Service
public class ServicoProduto {
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void deleteById(long id) {

		Produto produto = findById(id);

		if (produto == null) {
			throw new IllegalStateException(String.format("Could not find a entity with id=%1", id));
		}

		produtoRepository.deleteById(id);
	}

	public Produto update(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto update(Long id) {

		Produto produtoSalvo = produtoRepository.getById(id);
		if (id == null) {
			throw new IllegalStateException("Id cannot be null");
		}
		return produtoRepository.save(produtoSalvo);
	}

	public Produto findById(Long id) {
		if (id == null) {
			throw new IllegalStateException("Id cannot be null");
		}
		return produtoRepository.findById(id).get();
	}

	public Iterable<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public List<Produto> find(Produto filter) {
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));

		return produtoRepository.findAll(example);

	}

}
