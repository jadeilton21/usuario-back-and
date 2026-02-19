package com.jadeilton.usuario_back_end.infrastructure.repository;


import com.jadeilton.usuario_back_end.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {



    boolean existsByEmail(String email);
    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

}
