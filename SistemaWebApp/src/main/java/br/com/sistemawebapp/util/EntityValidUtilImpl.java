package br.com.sistemawebapp.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemawebapp.annotations.EntityUnique;

public class EntityValidUtilImpl<Entity extends Object> implements EntityValidUtil<Entity>{

	private List<Field> getFields(Entity entity, Object class1) {
		AnnotationUtil<?> annotationUtil = new AnnotationUtil<>();
		List<Field> fields = new ArrayList<Field>();
		for(Field field : entity.getClass().getDeclaredFields()) {
			if(field.getAnnotation(annotationUtil.classe(class1)) != null) {
				fields.add(field);
			}
		}
		
		return fields;
	}
	
	private boolean isClassAnntotation(Entity entity) {
		for(Annotation annotation : entity.getClass().getAnnotations()) {
			if(annotation.annotationType().getSimpleName().equals("EntityQuery")) {
				return true;
			}
		}
		
		
		return false;
	}
	
	@Override
	public boolean isEntityValid(Object object, Entity entity) {
		if(isClassAnntotation(entity)) {
			for(Field field : getFields(entity, object)) {
		        field.setAccessible(true);
		        try {
		        	System.out.println(field.getName());
		        	  if(field.get(entity) != null) {
		        		  String value = field.get(entity).toString();
		        		  if(!value.equals("")) {
		        			 
			        	  }
		        	  }
		          }catch (NullPointerException e) {
		        	  e.printStackTrace();
		          }  catch (IllegalArgumentException e) {
						e.printStackTrace();
		          } catch (IllegalAccessException e) {
						e.printStackTrace();
		          }
		        
			}
		}
		return false;
	}

}
