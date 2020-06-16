/**
 * 
 */
package br.com.sistemawebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemawebapp.model.Role;
import br.com.sistemawebapp.repository.RoleRepository;
import br.com.sistemawebapp.util.EntityService;

/**
 * @author antonio
 *
 */
@Service
public class RoleService implements EntityService<Role> {
	@Autowired
	private RoleRepository repository;

	@Override
	public void save(Role entity) {
		repository.saveAndFlush(entity);
	}

	@Override
	public void update(Role entity) {
		repository.saveAndFlush(entity);
	}

	@Override
	public void delete(Role entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String idCrypt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void restore(Role entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void restoreAll(List<Role> entitys) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public Role findOne(String idCrypt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findFirt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Role> findAllTrash() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllOrderByCresId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllOrderByCresId(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllOrderByCresId(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllOrderByDescId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllOrderByDescId(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllOrderByDescId(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllLimit(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllLimit(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllByOrderAlphabeticCres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllByOrderAlphabeticCres(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllByOrderAlphabeticCres(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllByOrderAlphabeticDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllByOrderAlphabeticDesc(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllByOrderAlphabeticDesc(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

}
