package br.com.sistemawebapp.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemawebapp.model.Funcionario;
import br.com.sistemawebapp.service.FuncionarioService;

@Service
public class EntityQueryDBImpl<Entity extends Object> implements EntityQueryDB<Entity>{
	private Object object;
	private Object objectReturn;
	private EntityValidUtilImpl<Entity> entityImpl = new EntityValidUtilImpl<Entity>();
	
	@Override
	public boolean isUpdate(Object object, Entity entity, Entity entityQuery) {
		return entityImpl.isEntityUpdate(object, entity, entityQuery);
	}
	
	@Override
	public boolean isIdUpdate(Object object, Entity entity) {
		return entityImpl.isIdUpdate(object, entity);
	}
	
	@Override
	public void setReturnObject(Object object) {
		this.objectReturn = object;
	}
	
	@Override
	public void setObject(Object object) {
		this.object = object;
	}
	
	@Override
	public Object getReturnObject() {
		return this.objectReturn;
	}
	
	@Override
	public boolean isExist(Object...ts) {
		for(Method method : this.object.getClass().getDeclaredMethods()) {
			for(Annotation annotation : method.getAnnotations()) {
				if(annotation.annotationType().getSimpleName().equals("ExecuteQuery")) {
					method.setAccessible(true);
					try {
						objectReturn = method.invoke(object, ts);
						if(objectReturn != null) {
							return true;
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}  
				}
			}
		}
		
		return false;
	}

}
