package com.testeadam.kanban.controller.cards;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testeadam.kanban.models.Card;
import com.testeadam.kanban.repository.CardsRespository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/cards")
public class CardController {
	
	@Autowired
	CardsRespository cardRepository;
	
	@GetMapping("/listar")
	public List<Card> listarPerfil(){
		return cardRepository.findAll();
	}
	@GetMapping("/pesquisar")
	public List<Card> listar(){
		return cardRepository.getListar();
	}
	
	
	@GetMapping("/buscarPorId/{id}")
	public Optional<Card> buscarPorId(@PathVariable("id") long id){
	 		return this.cardRepository.findById(id);
	}
	
	
	@PostMapping("/incluir")
	public Card cadastrarcard(@RequestBody Card card) {
		return this.cardRepository.save(card);
	}
	
	@PutMapping("/alterar")
	public Card alterar(@RequestBody Card card) {
		return this.cardRepository.save(card);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody Card card) {
		 this.cardRepository.delete(card);
	}
}
