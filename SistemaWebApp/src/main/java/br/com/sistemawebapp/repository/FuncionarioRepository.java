/**
 * 
 */
package br.com.sistemawebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemawebapp.model.Funcionario;

/**
 * @author antonio
 *
 */
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
