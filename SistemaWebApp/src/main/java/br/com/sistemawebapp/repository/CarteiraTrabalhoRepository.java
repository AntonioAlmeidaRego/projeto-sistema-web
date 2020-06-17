/**
 * 
 */
package br.com.sistemawebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sistemawebapp.model.CarteiraTrabalho;

/**
 * @author antonio
 *
 */
@Repository
public interface CarteiraTrabalhoRepository extends JpaRepository<CarteiraTrabalho, Long> {
	 
}
