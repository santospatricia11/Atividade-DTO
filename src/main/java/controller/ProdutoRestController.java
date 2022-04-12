package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.dto.Produto;
import servico.ServicoProduto;

@RestController
@RequestMapping("api/v1/pessoa")

public class ProdutoRestController {
	@Autowired
	private ServicoProduto servico;

	public ProdutoRestController(ServicoProduto servico) {
		super();
		this.servico = servico;
	}

	@PostMapping(value = "produto")

	@DeleteMapping(value = "/produto/{id}")
	public ResponseEntity<HttpStatus> deletePessoa(@PathVariable("id") long id) {
		try {
		servico.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/produto/{id}")
	public ResponseEntity<Produto> getDetinoById(@PathVariable("id") long id) {
		Optional<Produto> informacoesProduto = servico.findById(id);
		if (informacoesProduto.isPresent()) {
			return new ResponseEntity<Produto>(informacoesProduto.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/produto")
	public ResponseEntity<List<Produto>> getAllProduto() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();

			if (produtos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(produtos, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/produto/{id}")
	public ResponseEntity<Produto> updatePacote(@PathVariable("id") long id, @RequestBody Produto produto) {
		Optional<Produto> informacoesProduto = servico.findById(id);
		if (informacoesProduto.isPresent()) {
			Produto p = informacoesProduto.get();

			p.setNomeProduto(produto.getNomeProduto());

			return new ResponseEntity<>(servico.save(p), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
