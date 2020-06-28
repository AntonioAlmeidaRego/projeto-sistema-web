package br.com.sistemawebapp.util;

public interface EntityQueryDB<Entity extends Object> {
	// Método usado para setar o objeto que fará a consulta na base de dados
	public void setObject(Object object);

	// Método usado para setar o objeto que será retornado na consulta
	public void setReturnObject(Object object);

	// Método usado para retornar o objeto que foi consultado
	public Object getReturnObject();

	/*
	 * Método usado para verificar se existe uma entidade com os mesmos dados
	 * passado por parâmetro. Esse método possui uma possibilidade de infinitos
	 * parâmetros
	 */
	public boolean isExist(Object... objects);

	/*
	 * Método usado para verificar se a entidade atualizou seus atributos que são
	 * únicos. Esse método possui três parâmetros, tal como um
	 * objeto genérico vindo da interface
	 */
	public boolean isUpdate(Entity entity);

	/*
	 * Método usado para verificar se o atributo primário da entidade atualizou.
	 * Esse método possui dois parâmetros, tal como um objeto
	 * genérico vindo da interface
	 */
	public boolean isIdUpdate(Entity entity);
}
