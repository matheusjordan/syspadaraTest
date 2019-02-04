package syspadara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import syspadara.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
	
	Estoque findByNome(String nome);
	
	@Query(value = "select * from produto where nome like %:nome%",
			nativeQuery = true)
	List<Estoque> buscarProduto(@Param("nome") String nome);
	
}
