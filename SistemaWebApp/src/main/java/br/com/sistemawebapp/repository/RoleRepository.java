/**
 * 
 */
package br.com.sistemawebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemawebapp.model.Role;

/**
 * @author antonio
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
