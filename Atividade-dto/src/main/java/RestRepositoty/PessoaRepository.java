package RestRepositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Pessoa;



public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
