package br.com.sistemawebapp.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemawebapp.annotations.AttrUnique;

class ReturnFunction {
	public boolean isReturn = false;
	public String value = "";
}

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

	private ReturnFunction isFieldNotEmpty(Field field, Entity entity) {
		field.setAccessible(true); // acessar atributo
		ReturnFunction returnFunction = new ReturnFunction();
		try {
			if (field.get(entity) != null) { // verifica se o atributo possui um valor diferente de null
				String value = field.get(entity).toString();// retornar o valor do atributo
				if (!value.equals("")) { // verifica se o atributo não é vazio
					returnFunction.isReturn = true;
					returnFunction.value = value;
					return returnFunction;
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return returnFunction;
	}

	/*
	 * Método usado para verificar se a entidade atualizou seus atributos. Possui
	 * três parâmetros, tais como um objeto genérico e dois objetos que serão
	 * passados na interface genérica.
	 */
	@Override
	public boolean isEntityUpdate(Object object, Entity entity, Entity entityQuery) {
		Integer increment = 0; // usar uma variavel para incremento. Para verificar a quantidade de atributos
								// na classe
		if (isClassAnntotation(entity)) { // Verificar se a entidade possui anotação ("EntityQuery")
			for (Field field : getFields(entity, object)) {
				final boolean isNotEmpty = isFieldNotEmpty(field, entityQuery).isReturn;
				final String value = isFieldNotEmpty(field, entityQuery).value;
				if (isNotEmpty) {
					if (isFieldAnntotationUpdate(entityQuery)) { // verifica se o atributo possui
																	// anotação("AttrUpdate")
						String valueUp;
						try {
							valueUp = field.get(entityQuery).toString(); // retornar o valor vindo da
																			// entidade na consulta do banco
							if (!value.equals(valueUp)) { // verifica se o houve alteração
								increment++; // se for verdadeiro incrementa a variavel
							}
						} catch (IllegalArgumentException | IllegalAccessException e) {
							increment = -1;
							e.printStackTrace();
						}

					}
				}

			}
		}

		if (increment == getFields(entity, object).size()) {// Verifica se o tamanho de atributos com anotação e que
															// seja de acordo com a regra acima, é igual ao número de
															// atributos com anotação
			return true;
		}

		return false;
	}
	/*
	 * Método usado para verificar se a chave primaria da entidade foi atualizada. Possui
	 * dois parâmetros, tais como um objeto genérico e um objeto que será
	 * passado na interface genérica.
	 */
	@Override
	public boolean isIdUpdate(Object object, Entity entity) {
		if (isClassAnntotation(entity)) {// Verificar se a entidade possui anotação ("EntityQuery")
			for (Field field : getFields(entity, object)) {
				boolean existAnn = isFieldAnntotationIdUpdate(entity);
				if (existAnn) { // Verificar se o atributo possui anotação ("IdUpdate")
					// Se o retorno da função for verdadeiro retorna true, caso contrario false
					return isFieldNotEmpty(field, entity).isReturn == true ? true : false;
				}

			}
		}

		return false;
	}

	@Override
	public boolean isEntityValid(Object object, Entity entity, Entity entityQuery) {
		Integer increment = 0;// usar uma variavel para incremento. Para verificar a quantidade de atributos
								// na classe
		if (isClassAnntotation(entity)) {// Verificar se a entidade possui anotação ("EntityQuery")
			for (Field field : getFields(entity, object)) {
				if (isFieldNotEmpty(field, entityQuery).isReturn) { // Verificar se o atributo não é vazio e nem nulo
					increment++;
				}
			}
		}

		if (increment == getFields(entity, object).size()) {// Verifica se o tamanho de atributos com anotação e que
															// seja de acordo com a regra acima, é igual ao número de
															// atributos com anotação
			return true;
		}

		return false;
	}

}
