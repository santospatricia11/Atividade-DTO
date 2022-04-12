package servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import controller.ProdutoRestController;
import model.dto.Pessoa;
import model.dto.Produto;
import repository.PessoaRepository;
import repository.ProdutoRepository;

@Service

public class ServicoProduto{
	@Autowired
	private ProdutoRepository produtoR;
	
	public Produto save(Produto p) {
		return produtoR.save(p);
	}

	public Produto deleteById(long id) {
		return produtoR.getById(id);
	}

	public Optional<Produto> findById(long id) {
		return Optional.of(produtoR.findById((long) id).get());
	}

	public List<Produto> findAll() {
		return (List<Produto>) produtoR.findAll();
	}

	
	public List<Produto> findAllByTipoDestino(String produto, Pageable pageable) {
		return (List<Produto>) produtoR.findAll(pageable);
	}

	
	

}
