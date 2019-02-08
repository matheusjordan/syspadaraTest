package syspadara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import syspadara.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
