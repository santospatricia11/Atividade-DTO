package repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.dto.Pessoa;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	

}
