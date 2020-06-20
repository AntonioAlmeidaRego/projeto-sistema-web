package br.com.sistemawebapp.util;

import java.lang.annotation.Annotation;

public class AnnotationUtil<T extends Annotation> {
	public Class<T> classe(Object class1) {
		return (Class<T>) class1;
	}
}
