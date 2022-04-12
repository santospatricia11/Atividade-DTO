package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import model.dto.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
