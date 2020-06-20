package br.com.sistemawebapp.util;

public interface EntityValidUtil<Entity extends Object> {
	public boolean isEntityValid(Object object, Entity entity);
}
