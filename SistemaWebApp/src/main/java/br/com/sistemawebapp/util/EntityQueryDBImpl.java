package br.com.sistemawebapp.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemawebapp.annotations.AttrUpdate;
import br.com.sistemawebapp.annotations.IdUpdate;
import br.com.sistemawebapp.model.Funcionario;
import br.com.sistemawebapp.service.FuncionarioService;

@Service
public class EntityQueryDBImpl<Entity extends Object> implements EntityQueryDB<Entity> {
	private Object object; // atributo usado para receber o objeto que fara a consulta
	private Object objectReturn; // atributo usado para receber e retornar o resultado da consulta
	private EntityValidUtilImpl<Entity> entityImpl = new EntityValidUtilImpl<Entity>();

	/*
	 * Método usado para verificar se a entidade atualizou seus atributos que são
	 * únicos. Esse método possui três parâmetros, tal como um
	 * objeto genérico vindo da interface
	 */
	@Override
	public boolean isUpdate(Entity entity) {
		return entityImpl.isEntityUpdate(AttrUpdate.class, entity, (Entity) objectReturn);
	}

	/*
	 * Método usado para verificar se o atributo primário da entidade atualizou.
	 * Esse método possui um parâmetro, tal como um objeto
	 * genérico vindo da interface
	 */
	@Override
	public boolean isIdUpdate(Entity entity) {
		return entityImpl.isIdUpdate(IdUpdate.class, entity);
	}

	// Método usado para setar o objeto que será retornado na consulta
	@Override
	public void setReturnObject(Object object) {
		this.objectReturn = object;
	}

	// Método usado para setar o objeto que fará a consulta na base de dados
	@Override
	public void setObject(Object object) {
		this.object = object;
	}

	// Método usado para retornar o objeto que foi consultado
	@Override
	public Object getReturnObject() {
		return this.objectReturn;
	}

	/*
	 * Método usado para verificar se existe uma entidade com os mesmos dados
	 * passado por parâmetro. Esse método possui uma possibilidade de infinitos
	 * parâmetros
	 */
	@Override
	public boolean isExist(Object... ts) {
		for (Method method : this.object.getClass().getDeclaredMethods()) {
			for (Annotation annotation : method.getAnnotations()) {
				if (annotation.annotationType().getSimpleName().equals("ExecuteQuery")) {
					method.setAccessible(true);
					try {
						objectReturn = method.invoke(object, ts);
						if (objectReturn != null) {
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
