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
import br.com.sistemawebapp.util.CryptUtil;
import br.com.sistemawebapp.util.EntityService;

/**
 * @author antonio
 *
 */

@Service
public class FuncionarioService implements EntityService<Funcionario> {
	@Autowired
	private FuncionarioRepository repository;
	private CryptUtil cryptUtil = new CryptUtil();
	
	@Override
	public void save(Funcionario entity) {
		entity.setExcluir(false);
		entity.setIdCrypt(cryptUtil.crypId());
		repository.saveAndFlush(entity);
	}

	@Override
	public void update(Funcionario entity) {
		Funcionario funcionario = getOne(entity.getId());
		entity.setIdCrypt(funcionario.getIdCrypt());
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
		return repository.findOne(idCrypt);
	}
	
	public Funcionario getOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public Funcionario findLast() {
		return null;
	}

	@Override
	public Funcionario findFirt() {
		return null;
	}

	@Override
	public List<Funcionario> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Funcionario> findAllTrash() {
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByCresId() {
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByCresId(Long limit) {
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByCresId(Long limitOne, Long limitTwo) {
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByDescId() {
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByDescId(Long limit) {
		return null;
	}

	@Override
	public List<Funcionario> findAllOrderByDescId(Long limitOne, Long limitTwo) {
		return null;
	}

	@Override
	public List<Funcionario> findAllLimit(Long limit) {
		return null;
	}

	@Override
	public List<Funcionario> findAllLimit(Long limitOne, Long limitTwo) {
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticCres() {
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticCres(Long limit) {
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticCres(Long limitOne, Long limitTwo) {
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticDesc() {
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticDesc(Long limit) {
		return null;
	}

	@Override
	public List<Funcionario> findAllByOrderAlphabeticDesc(Long limitOne, Long limitTwo) {
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
