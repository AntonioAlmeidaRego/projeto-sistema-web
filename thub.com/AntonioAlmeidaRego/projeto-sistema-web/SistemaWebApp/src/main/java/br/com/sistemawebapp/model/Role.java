/**
 * 
 */
package br.com.sistemawebapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author antonio
 *
 */
@Entity
@Table(name = "role_tb")
public class Role implements Serializable {

	/*
	 * Anotação @Id responsável por definir a chave primaria da tabela. E esse
	 * atributo deverá ser do tipo Long ou Integer
	 */

	/*
	 * Anotação @GeneratedValue(strategy = GenerationType.Auto) responsável por auto
	 * incrementar o atributo que contenha a chave primaria.
	 */

	/*
	 * Anotação @Column responsável por definir informações sobre a coluna da
	 * tabela. Tais, como o nome, tamanho de caracteres, se a coluna por padrão é
	 * nula e entre outros
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
