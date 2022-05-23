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

import Servico.PessoaServicoImplConvert;
import Servico.ServicoPessoa;

import dto.PessoaDTO;
import model.Pessoa;

@RestController
@RequestMapping("/api/pessoa")

public class PessoaRestController {

	@Autowired
	private PessoaServicoImplConvert pessoaServicoImplConvert;
	@Autowired
	private ServicoPessoa servicoPessoa;

	@PostMapping
	public ResponseEntity<Object > createPessoa(@RequestBody PessoaDTO pessoaDTO) {
		try {
			Pessoa entity = pessoaServicoImplConvert.dtoToPessoa(pessoaDTO);
			entity = servicoPessoa.save(entity);
			pessoaDTO = pessoaServicoImplConvert.pessoaToDTO(pessoaDTO);
			// destinoToDTO(entity);

			//return new ResponseEntity(pessoaDTO, HttpStatus.CREATED);
			return new ResponseEntity<Object>(pessoaDTO, HttpStatus.CREATED);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping
	// (value="/{cpf}")
	public ResponseEntity deletePessoa(@PathVariable("cpf") long cpf) {
		try {
			servicoPessoa.deleteById(cpf);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/{cpf}")
	public ResponseEntity<PessoaDTO> getDetinoById(@PathVariable("id") long cpf) {
		Pessoa pessoa = servicoPessoa.findById(cpf);

		if (pessoa != null) {
			PessoaDTO pessoaDTO = new PessoaDTO();
			BeanUtils.copyProperties(pessoa, pessoaDTO);
			return ResponseEntity.ok(pessoaDTO);
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping(value = "/pessoa")
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

	@PutMapping(value = "/pessoas/{cpf}")
	public ResponseEntity<Pessoa> updatePacote(@PathVariable("cpf") long cpf, @RequestBody Pessoa pessoa) {
		Optional<Pessoa> informacoesPessoas = Optional.ofNullable(servicoPessoa.findById(cpf));
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
