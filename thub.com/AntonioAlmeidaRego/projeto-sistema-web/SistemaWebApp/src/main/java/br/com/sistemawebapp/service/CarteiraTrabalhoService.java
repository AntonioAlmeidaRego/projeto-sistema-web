/**
 * 
 */
package br.com.sistemawebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemawebapp.model.CarteiraTrabalho;
import br.com.sistemawebapp.repository.CarteiraTrabalhoRepository;
import br.com.sistemawebapp.util.EntityService;

/**
 * @author antonio
 *
 */
@Service
public class CarteiraTrabalhoService implements EntityService<CarteiraTrabalho> {
	@Autowired
	private CarteiraTrabalhoRepository repository;
	
	
	@Override
	public void save(CarteiraTrabalho entity) {
		entity.setExcluir(false);
		repository.saveAndFlush(entity);
	}

	@Override
	public void update(CarteiraTrabalho entity) {
		repository.saveAndFlush(entity);		
	}

	@Override
	public void delete(CarteiraTrabalho entity) {
		entity.setExcluir(true);
		update(entity);
	}

	@Override
	public void delete(String idCrypt) {
		CarteiraTrabalho carteiraTrabalho = findOne(idCrypt);
		carteiraTrabalho.setExcluir(true);
		update(carteiraTrabalho);
		
	}

	@Override
	public void restore(CarteiraTrabalho entity) {
		entity.setExcluir(false);
		
	}

	@Override
	public void restoreAll(List<CarteiraTrabalho> entitys) {
		for(CarteiraTrabalho carteiraTrabalho : entitys) {
			carteiraTrabalho.setExcluir(false);
			update(carteiraTrabalho);
		}
		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarteiraTrabalho findOne(String idCrypt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarteiraTrabalho findLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarteiraTrabalho findFirt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllTrash() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllOrderByCresId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllOrderByCresId(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllOrderByCresId(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllOrderByDescId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllOrderByDescId(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllOrderByDescId(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllLimit(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllLimit(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllByOrderAlphabeticCres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllByOrderAlphabeticCres(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllByOrderAlphabeticCres(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllByOrderAlphabeticDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllByOrderAlphabeticDesc(Long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteiraTrabalho> findAllByOrderAlphabeticDesc(Long limitOne, Long limitTwo) {
		// TODO Auto-generated method stub
		return null;
	}

}
