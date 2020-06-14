package br.com.sistemawebapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* A serialização em Java é o processo no qual a 
 * instância de um objeto é transformada em uma sequência 
 * de bytes e é útil quando precisamos enviar objetos pela rede, 
 * salvar no disco, ou comunicar de uma JVM com outra. 
 * Isso porque o estado atual do objeto é “congelado” e na outra “ponta” 
 * nós podemos “descongelar” este objeto sem perder nenhuma informação.
 * Fonte: https://www.devmedia.com.br/use-a-serializacao-em-java-com-seguranca/29012
 * */

// Class Java Cliente 

@Entity // Anotação que será responsável por criar a tabela na base de dados
@Table(name = "cliente_tb") // Anotação que renomeará o nome da tabela, seguindo o padrão SQL, caso não use
							// essa @Table, o próprio JPA criará com o mesmo nome da class, mas seguindo o
							// padrão
public class Cliente implements Serializable {

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
	@Column(name = "nome_cl", length = 40, nullable = false)
	private String nome;
	@Column(name = "telefone_cl", length = 20, nullable = false)
	private String telefone;
	@Column(name = "estado_cl", length = 40, nullable = false)
	private String estado;
	@Column(name = "cidade_cl", length = 40, nullable = false)
	private String cidade;
	@Column(name = "rua_cl", length = 90, nullable = false)
	private String rua;
	@Column(name = "numero_cl", length = 10, nullable = false)
	private String numero;
	@Column(name = "bairro_cl", length = 120, nullable = false)
	private String bairro;
	@Column(name = "complemento_cl", length = 255, nullable = false)
	private String complemento;
	@Column(name = "ponto_referencia_cl", length = 255, nullable = false)
	private String pontoReferencia;

	// Métodos (Gets e Sets)

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
	
}
