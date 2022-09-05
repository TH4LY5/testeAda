package com.testeadam.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testeadam.kanban.models.Coluna;

@Repository
public interface ColunaRespository extends JpaRepository<Coluna, Long>{

}
