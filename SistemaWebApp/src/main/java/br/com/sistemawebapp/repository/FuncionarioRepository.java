/**
 * 
 */
package br.com.sistemawebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sistemawebapp.model.Funcionario;

/**
 * @author antonio
 *
 */
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	@Query(value="select * from funcionario_tb f where f.excluir = false", nativeQuery = true)
	public List<Funcionario> findAll();
	@Query(value="select * from funcionario_tb f where f.id_crypt = ?", nativeQuery = true)
	public Funcionario findOne(String idCrypt);
	@Query(value="select * from funcionario_tb f where f.cpf_cl = ? or f.rg_cl = ?", nativeQuery = true)
	public Funcionario findByCPFOrRG(String cpf, String rg);
}	
