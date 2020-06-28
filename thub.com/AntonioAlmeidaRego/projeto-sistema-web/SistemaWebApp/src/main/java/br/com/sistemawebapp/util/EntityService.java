/**
 * 
 */
package br.com.sistemawebapp.util;

import java.util.List;

/**
 * @author antonio
 *
 */
// Class Generica
public interface EntityService<T extends Object> {
	public void save(T entity);
	public void update(T entity);
	public void delete(T entity);
	public void delete(String idCrypt);
	public void restore(T entity);
	public void restoreAll(List<T> entitys);
	public Long count();
	public T findOne(String idCrypt);
	public T findLast();
	public T findFirt();
	public List<T> findAll();
	public List<T> findAllTrash();
	public List<T> findAllOrderByCresId();
	public List<T> findAllOrderByCresId(Long limit);
	public List<T> findAllOrderByCresId(Long limitOne, Long limitTwo);
	public List<T> findAllOrderByDescId();
	public List<T> findAllOrderByDescId(Long limit);
	public List<T> findAllOrderByDescId(Long limitOne, Long limitTwo);
	public List<T> findAllLimit(Long limit);
	public List<T> findAllLimit(Long limitOne, Long limitTwo);
	public List<T> findAllByOrderAlphabeticCres();
	public List<T> findAllByOrderAlphabeticCres(Long limit);
	public List<T> findAllByOrderAlphabeticCres(Long limitOne, Long limitTwo);
	public List<T> findAllByOrderAlphabeticDesc();
	public List<T> findAllByOrderAlphabeticDesc(Long limit);
	public List<T> findAllByOrderAlphabeticDesc(Long limitOne, Long limitTwo);
}
