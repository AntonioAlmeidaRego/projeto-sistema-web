package br.com.sistemawebapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario_tb")
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nome_cl", nullable = false, length = 40)
	private String nome;
	@Column(name = "cpf_cl", nullable = false, length = 20)
	private String cpf;
	@Column(name = "rg_cl", nullable = false, length = 20)
	private String rg;
	@Column(name = "telefone_cl", nullable = false, length = 20)
	private String telefone;
	@Column(name = "numero_carteira_trabalho_cl", nullable = false, length = 30)
	private String numeroCarteiraTrabalho;
	private boolean activo;

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

	public String getNumeroCarteiraTrabalho() {
		return numeroCarteiraTrabalho;
	}

	public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
		this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
