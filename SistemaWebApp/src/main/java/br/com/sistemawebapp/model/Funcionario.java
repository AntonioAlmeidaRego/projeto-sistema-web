package br.com.sistemawebapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.sistemawebapp.annotations.EntityQuery;
import br.com.sistemawebapp.annotations.AttrUnique;
import br.com.sistemawebapp.annotations.AttrUpdate;
import br.com.sistemawebapp.annotations.IdUpdate;

@Entity
@Table(name = "funcionario_tb")
@EntityQuery
public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	@IdUpdate
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nome_cl", nullable = false, length = 40)
	private String nome;
	@AttrUpdate
	@AttrUnique
	@Column(name = "cpf_cl", nullable = false, length = 20)
	private String cpf;
	@AttrUnique
	@AttrUpdate
	@Column(name = "rg_cl", nullable = false, length = 20)
	private String rg;
	@Column(name = "telefone_cl", nullable = false, length = 20)
	private String telefone;
	private boolean excluir;
	private String idCrypt;
	@OneToOne
	@JoinColumn(name = "carteira_trabalho_id")
	private CarteiraTrabalho carteiraTrabalho;
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public CarteiraTrabalho getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(CarteiraTrabalho carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public String getIdCrypt() {
		return idCrypt;
	}

	public void setIdCrypt(String idCrypt) {
		this.idCrypt = idCrypt;
	}

}
