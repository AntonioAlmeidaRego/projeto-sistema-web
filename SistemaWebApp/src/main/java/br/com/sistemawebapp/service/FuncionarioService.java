/**
 * 
 */
package br.com.sistemawebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemawebapp.model.Funcionario;
import br.com.sistemawebapp.repository.FuncionarioRepository;
import br.com.sistemawebapp.util.EntityService;

/**
 * @author antonio
 *
 */

@Service
public class FuncionarioService implements EntityService<Funcionario> {
	@Autowired
	private FuncionarioRepository repository;
	
	@Override
	public void save(Funcionario entity) {
		repository.saveAndFlush(entity);
	}

	@Override
	public void update(Funcionario entity) {
		repository.saveAndFlush(entity);
	}

	@Override
	public void delete(Funcionario entity) {
		
	}

	@Override
	public void delete(String idCrypt) {
		
	}

	@Override
	public void restore(Funcionario entity) {
		
	}

	@Override
	public void restoreAll(List<Funcionario> entitys) {
		
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public Funcionario findOne(String idCrypt) {
		return null;
	}

	@Override
	public Funcionario findLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario findFirt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Funcionario> findAllTrash() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByCresId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByCresId(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByCresId(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByDescId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByDescId(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByDescId(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllLimit(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllLimit(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticCres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticCres(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticCres(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticDesc(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticDesc(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

}
