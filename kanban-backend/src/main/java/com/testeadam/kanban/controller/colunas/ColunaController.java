package com.testeadam.kanban.controller.colunas;

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

import com.testeadam.kanban.models.Coluna;
import com.testeadam.kanban.repository.ColunaRespository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/coluna")
public class ColunaController {
	
	@Autowired
	ColunaRespository colunaRepository;
	
	@GetMapping("/listar")
	public List<Coluna> listarPerfil(){
		return colunaRepository.findAll();
	}
	
	
	@GetMapping("/buscarPorId/{id}")
	public Optional<Coluna> buscarPorId(@PathVariable("id") long id){
	 		return this.colunaRepository.findById(id);
	}
	
	
	@PostMapping("/incluir")
	public Coluna cadastrarColuna(@RequestBody Coluna coluna) {
		return this.colunaRepository.save(coluna);
	}
	
	@PutMapping("/alterar")
	public Coluna alterar(@RequestBody Coluna coluna) {
		return this.colunaRepository.save(coluna);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody Coluna coluna) {
		 this.colunaRepository.delete(coluna);
	}
}
