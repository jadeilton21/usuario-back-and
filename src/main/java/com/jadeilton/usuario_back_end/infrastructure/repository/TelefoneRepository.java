package com.jadeilton.usuario_back_end.infrastructure.repository;



import com.jadeilton.usuario_back_end.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone,Long> {
}
