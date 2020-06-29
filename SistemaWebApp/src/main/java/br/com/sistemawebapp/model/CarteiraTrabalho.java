/**
 * 
 */
package br.com.sistemawebapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author antonio
 *
 */
@Entity
@Table(name = "carteira_trabalho_tb")
public class CarteiraTrabalho implements Serializable {

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
	private Integer numero;
	@Temporal(TemporalType.DATE)
	private Date dateEmissao;
	private String uf;
	private boolean excluir;

	// falta um atributo
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDateEmissao() {
		return dateEmissao;
	}

	public void setDateEmissao(Date dateEmissao) {
		this.dateEmissao = dateEmissao;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isExcluir() {
		return excluir;
	}

	public void setExcluir(boolean excluir) {
		this.excluir = excluir;
	}

}
