/**
 * 
 */
package br.com.sistemawebapp.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemawebapp.annotations.ExecuteQuery;
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
		Random random = new Random(1000); // uso previo para não importar a segurança e não causar problemas...
		entity.setExcluir(false);
		entity.setIdCrypt(String.valueOf(random.nextInt()));
		repository.saveAndFlush(entity);
	}

	@Override
	public void update(Funcionario entity) {
		entity.setIdCrypt(entity.getIdCrypt());
		repository.saveAndFlush(entity);
	}

	@Override
	public void delete(Funcionario entity) {
		entity.setExcluir(true);
		update(entity);
	}

	@Override
	public void delete(String idCrypt) {
		Funcionario entity = findOne(idCrypt);
		update(entity);
	}

	@Override
	public void restore(Funcionario entity) {
		// implementar Julia
	}

	@Override
	public void restoreAll(List<Funcionario> entitys) {
		// implementar Julia
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public Funcionario findOne(String idCrypt) {
		return repository.findOne(idCrypt);
	}

	@Override
	public Funcionario findLast() {
		// implementar Julia
		return null;
	}

	@Override
	public Funcionario findFirt() {
		// implementar Julia
		return null;
	}

	@Override
	public List<Funcionario> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Funcionario> findAllTrash() {
		// implementar Julia
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByCresId() {
		// implementar membro do Grupo de Julia
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByCresId(Long limit) {
		// implementar membro do Grupo de Julia
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByCresId(Long limitOne, Long limitTwo) {
		// implementar membro do Grupo de Julia
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByDescId() {
		// implementar membro do Grupo de Julia
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByDescId(Long limit) {
		// implementar membro do Grupo de Julia
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByDescId(Long limitOne, Long limitTwo) {
		// implementar membro do Grupo de Julia junto com ela
		return null;
	}

	@Override
	public List<Funcionario> findAllLimit(Long limit) {
		// implementar membro do Grupo de Julia junto com ela
		return null;
	}

	@Override
	public List<Funcionario> findAllLimit(Long limitOne, Long limitTwo) {
		// implementar membro do Grupo de Julia junto com ela
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticCres() {
		// implementar membro do Grupo de Julia junto com ela
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticCres(Long limit) {
		// implementar membro do Grupo de Julia junto com ela
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticCres(Long limitOne, Long limitTwo) {
		// implementar membro do Grupo de Julia junto com ela
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticDesc() {
		// implementar membro do Grupo de Julia junto com ela
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticDesc(Long limit) {
		// implementar membro do Grupo de Julia junto com ela
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticDesc(Long limitOne, Long limitTwo) {
		// implementar membro do Grupo de Julia junto com ela
		return null;
	}

	@ExecuteQuery
	public Funcionario findByCPFOrRG(String cpf, String rg) {
		return repository.findByCPFOrRG(cpf, rg);
	}

	public Funcionario findByIdCrypt(String idCrypt) {
		return repository.findByIdCrypt(idCrypt);
	}
}
