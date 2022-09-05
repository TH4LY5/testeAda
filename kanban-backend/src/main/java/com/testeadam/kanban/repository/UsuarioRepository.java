package com.testeadam.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testeadam.kanban.models.Usuario;

@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, Long>{

}
 