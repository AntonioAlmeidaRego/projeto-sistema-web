package br.com.sistemawebapp.util;

public interface EntityQueryDB<Entity extends Object> {
	public void setObject(Object object);
	public void setReturnObject(Object object);
	public Object getReturnObject();
	public boolean isExist(Object...objects);
	public boolean isUpdate(Object object, Entity entity, Entity entityQuery);
	public boolean isIdUpdate(Object object, Entity entity);
}
