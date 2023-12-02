package br.com.ipohealth.appgs.repository;

import br.com.ipohealth.appgs.entity.DTO.UsuarioDTO;
import br.com.ipohealth.appgs.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmailUsuario(String email);

}
