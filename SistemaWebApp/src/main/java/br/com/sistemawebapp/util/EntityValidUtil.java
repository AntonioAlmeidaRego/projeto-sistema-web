package br.com.sistemawebapp.util;

public interface EntityValidUtil<Entity extends Object> {
	/*
	 * Método usado para verificar se a entidade é valida. Possui três parâmetros,
	 * tais como um objeto genérico e dois objetos que serão passados na interface
	 * genérica.
	 */
	public boolean isEntityValid(Object object, Entity entity, Entity entityQuery);

	/*
	 * Método usado para verificar se a entidade atualizou seus atributos. Possui
	 * três parâmetros, tais como um objeto genérico e dois objetos que serão
	 * passados na interface genérica.
	 */
	public boolean isEntityUpdate(Object object, Entity entity, Entity entityQuery);

	/*
	 * Método usado para verificar se a chave primaria da entidade foi atualizada. Possui
	 * dois parâmetros, tais como um objeto genérico e um objeto que será
	 * passado na interface genérica.
	 */
	public boolean isIdUpdate(Object object, Entity entity);
}
