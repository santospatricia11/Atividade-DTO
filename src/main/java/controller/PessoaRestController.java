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

import model.dto.Pessoa;
import servico.ServicoPessoa;

@RestController
@RequestMapping("api/pessoa")
public class PessoaRestController {
	
	@Autowired(required=true)
	private ServicoPessoa servicoPessoa;

	@PostMapping(value="pessoa")
	
	public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
		try {
			Pessoa dest =servicoPessoa.save(pessoa);
			return new ResponseEntity<>(dest, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value="/{cpf}")
	public ResponseEntity<HttpStatus> deletePessoa(@PathVariable("cpf") long cpf) {
		try {
			servicoPessoa.deleteById(cpf);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value="/pessoa/{cpf}")
	public ResponseEntity<Pessoa> getDetinoById(@PathVariable("id") long cpf) {
		Optional<Pessoa> informacoesPessoas = servicoPessoa.findById(cpf);
		if (informacoesPessoas.isPresent()) {
			return new ResponseEntity<>(informacoesPessoas.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value="/pessoa")
	public ResponseEntity<List<Pessoa>> getAllPessoa() {
		try {
			List<Pessoa> pessoas = new ArrayList<Pessoa>();

			if (pessoas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(pessoas, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value="/pessoas/{cpf}")
	public ResponseEntity<Pessoa> updatePacote(@PathVariable("cpf") long cpf, @RequestBody Pessoa pessoa) {
		Optional<Pessoa> informacoesPessoas = servicoPessoa.findById(cpf);
		if (informacoesPessoas.isPresent()) {
			Pessoa p = informacoesPessoas.get();

			p.setNome(pessoa.getNome());
			p.setEndereco(pessoa.getEndereco());
			p.setTipo(pessoa.getTipo());
		

			return new ResponseEntity<>(servicoPessoa.save(p), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
