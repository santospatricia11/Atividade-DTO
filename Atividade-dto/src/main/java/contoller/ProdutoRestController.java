package contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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

import Servico.ServicoPessoa;
import Servico.ServicoProduto;
import Servico.ServicoProdutoConverte;
import Servico.ServicoProdutoImplConverte;
import dto.ProdutoDTO;
import model.Produto;

@RestController
@RequestMapping("api/pessoa")

public class ProdutoRestController {
	@Autowired
	private ServicoProdutoImplConverte servicoProdutoImplConverte;
	private ServicoProduto servicoProduto;

	public ProdutoRestController(ServicoProdutoImplConverte servicoProdutoImplConverte) {
		super();
		this.servicoProdutoImplConverte = servicoProdutoImplConverte;
	}

	@PostMapping(value = "produto")

	@DeleteMapping(value = "/{id}")
	public ResponseEntity deletePessoa(@PathVariable("id") long id) {
		try {
			servicoProdutoImplConverte.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable Long id) {
		Produto produto = servicoProduto.findById(id);
		if (produto != null) {
			ProdutoDTO produtoDTO = new ProdutoDTO();
			BeanUtils.copyProperties(produto, produtoDTO);
			return ResponseEntity.ok(produtoDTO);
		}

		return ResponseEntity.notFound().build();
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
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody ProdutoDTO produtoDTO) {
		try {
			produtoDTO.setId(id);
			ProdutoDTO entity = servicoProdutoImplConverte.dtoProduto(produtoDTO);

			// entity = servicoProduto.update(entity);
			// update(entity);
			produtoDTO = servicoProdutoImplConverte.produtoToDTO(produtoDTO);

			return ResponseEntity.ok(produtoDTO);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
