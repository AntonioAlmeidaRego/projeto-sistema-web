package br.com.sistemawebapp.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemawebapp.annotations.AttrUnique;

public class EntityValidUtilImpl<Entity extends Object> implements EntityValidUtil<Entity> {
	/*
	 * Método privado para retornar uma lista de field (atributos da entidade
	 * passado por parâmetro) e um objeto genérico por parâmetro.
	 */
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

	/*
	 * Método privado para verificar se a entidade genérica possui anotação
	 * “EntityQuery”. Se for verdadeiro mostra-se que o objeto será realizado
	 * consulta na base de dados.
	 */
	private boolean isClassAnntotation(Entity entity) {
		for (Annotation annotation : entity.getClass().getAnnotations()) {
			if (annotation.annotationType().getSimpleName().equals("EntityQuery")) {
				return true;
			}
		}

		return false;
	}

	/*
	 * Método privado para verificar se a entidade genérica possui anotação nos
	 * atributos “AttrUpdate”. Se for verdadeiro mostra-se que os atributos serão
	 * verificados se houveram alterações.
	 */
	private boolean isFieldAnntotationUpdate(Entity entity) {
		for (Field field : entity.getClass().getDeclaredFields()) {
			for (Annotation annotation : field.getAnnotations()) {
				if (annotation.annotationType().getSimpleName().equals("AttrUpdate")) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * Método privado para verificar se a entidade genérica possui anotação no
	 * atributo com a chave primária “IdUpdate”. Se for verdadeiro mostra-se que o
	 * atributo será verificado se houve alteração.
	 */
	private boolean isFieldAnntotationIdUpdate(Entity entity) {
		for (Field field : entity.getClass().getDeclaredFields()) {
			for (Annotation annotation : field.getAnnotations()) {
				if (annotation.annotationType().getSimpleName().equals("IdUpdate")) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * Método usado para verificar se a entidade atualizou seus atributos. Possui
	 * três parâmetros, tais como um objeto genérico e dois objetos que serão
	 * passados na interface genérica.
	 */
	@Override
	public boolean isEntityUpdate(Object object, Entity entity, Entity entityQuery) {
		Integer increment = 0; // usar uma variavel para incremento. Para verificar a quantidade de atributos na classe
		if (isClassAnntotation(entity)) { // Verificar se a entidade possui anotação ("EntityQuery")
			for (Field field : getFields(entity, object)) {
				field.setAccessible(true); // acessar atributo
				try {

					if (field.get(entity) != null) { // verifica se o atributo possui um valor diferente de null

						String value = field.get(entity).toString(); // retornar o valor do atributo
						if (!value.equals("")) { // verifica se o valor não está vazio
							if (isFieldAnntotationUpdate(entityQuery)) { // verifica se o atributo possui
																			// anotação("AttrUpdate")
								String valueUp = field.get(entityQuery).toString(); // retornar o valor vindo da entidade na consulta do banco
								if (!value.equals(valueUp)) { // verifica se o houve alteração
									increment++; // se for verdadeiro incrementa a variavel
								}
							}
						}
					}
				} catch (NullPointerException e) {
					increment = -1;
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					increment = -1;
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					increment = -1;
					e.printStackTrace();
				}

			}
		}

		if (increment == getFields(entity, object).size()) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isIdUpdate(Object object, Entity entity) {
		if (isClassAnntotation(entity)) {
			for (Field field : getFields(entity, object)) {
				boolean existAnn = isFieldAnntotationIdUpdate(entity);
				if (existAnn) {
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
