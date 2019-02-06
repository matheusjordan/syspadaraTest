package syspadara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import syspadara.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{
	
	@Query(value="select * from venda order by id", nativeQuery = true)
	List<Venda> findAll();
}
