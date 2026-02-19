package com.jadeilton.usuario_back_end.infrastructure.repository;

import com.javanauta.aprendendoSpringBoot.infra.entity.Endereco;
import com.javanauta.aprendendoSpringBoot.infra.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
