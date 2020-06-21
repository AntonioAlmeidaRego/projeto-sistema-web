package br.com.sistemawebapp.util;

public interface EntityValidUtil<Entity extends Object> {
	public boolean isEntityValid(Object object, Entity entity, Entity entityQuery);
	public boolean isEntityUpdate(Object object, Entity entity, Entity entityQuery);
	public boolean isIdUpdate(Object object, Entity entity);
}
