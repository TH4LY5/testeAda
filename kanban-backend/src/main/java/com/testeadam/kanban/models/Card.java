package com.testeadam.kanban.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name="TB_CARD")
public class Card implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public long id;
	@NotNull
	@Column(name = "TITULO")
	public String titulo;
	
	@Column(name = "CONTEUDO")
	public String conteudo;
	
	@Column(name= "ID_COLUNA")
	public Coluna coluna;
	
	
}
