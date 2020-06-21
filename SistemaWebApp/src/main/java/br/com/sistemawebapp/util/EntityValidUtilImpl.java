package br.com.sistemawebapp.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemawebapp.annotations.AttrUnique;

public class EntityValidUtilImpl<Entity extends Object> implements EntityValidUtil<Entity> {

	private List<Field> getFields(Entity entity, Object class1) {
		AnnotationUtil<?> annotationUtil = new AnnotationUtil<>();
		List<Field> fields = new ArrayList<Field>();
		for (Field field : entity.getClass().getDeclaredFields()) {
			if (field.getAnnotation(annotationUtil.classe(class1)) != null) {
				fields.add(field);
			}
		}

		return fields;
	}

	private boolean isClassAnntotation(Entity entity) {
		for (Annotation annotation : entity.getClass().getAnnotations()) {
			if (annotation.annotationType().getSimpleName().equals("EntityQuery")) {
				return true;
			}
		}

		return false;
	}

	private boolean isFieldAnntotationUpdate(Entity entity) {
		for (Field field : entity.getClass().getDeclaredFields()) {
			for(Annotation annotation : field.getAnnotations()) {
				if (annotation.annotationType().getSimpleName().equals("AttrUpdate")) {
					return true;
				}
			}
		}

		return false;
	}
	
	private boolean isFieldAnntotationIdUpdate(Entity entity) {
		for (Field field : entity.getClass().getDeclaredFields()) {
			for(Annotation annotation : field.getAnnotations()) {
				if (annotation.annotationType().getSimpleName().equals("IdUpdate")) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public boolean isEntityUpdate(Object object, Entity entity, Entity entityQuery) {
		List<Integer> list = new ArrayList<Integer>();
		if (isClassAnntotation(entity)) {
			for (Field field : getFields(entity, object)) {
				field.setAccessible(true);
				try {

					if (field.get(entity) != null) {

						String value = field.get(entity).toString();
						if (!value.equals("")) {
							if (isFieldAnntotationUpdate(entityQuery)) {
								String valueUp = field.get(entityQuery).toString();
								if (!value.equals(valueUp)) {
									list.add(0);
								}
							}
						}
					}
				} catch (NullPointerException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
		}

		if (list.size() == getFields(entity, object).size()) {
			return true;
		}

		return false;
	}
	
	@Override
	public boolean isIdUpdate(Object object, Entity entity) {
		if (isClassAnntotation(entity)) {
			for (Field field : getFields(entity, object)) {
				boolean existAnn = isFieldAnntotationIdUpdate(entity);
				System.out.println(existAnn);
				if(existAnn) {
					field.setAccessible(true);
					try {

						if (field.get(entity) != null) {
							String value = field.get(entity).toString();
							if (!value.equals("")) {
								return true;
							}
						}
					} catch (NullPointerException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
					
			}
		}

		return false;
	}

	@Override
	public boolean isEntityValid(Object object, Entity entity, Entity entityQuery) {
		List<Integer> list = new ArrayList<Integer>();
		if (isClassAnntotation(entity)) {
			for (Field field : getFields(entity, object)) {
				field.setAccessible(true);
				try {

					if (field.get(entity) != null) {
						String value = field.get(entity).toString();
						if (!value.equals("")) {
							list.add(0);
						}
					}
				} catch (NullPointerException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
		}

		if (list.size() == getFields(entity, object).size()) {
			return true;
		}

		return false;
	}

}
