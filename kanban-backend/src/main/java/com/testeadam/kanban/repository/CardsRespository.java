package com.testeadam.kanban.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testeadam.kanban.models.Card;

@Repository
public interface  CardsRespository extends JpaRepository<Card, Long>{
	@Query(value="select tb.* from TB_CARD tb " + 
			"WHERE ATIVO = 1",nativeQuery = true)
	public List<Card> getListar();
}
