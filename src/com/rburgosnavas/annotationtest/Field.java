package com.rburgosnavas.annotationtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used in a class' fields to tag them with a specific key.
 * A type can also be declared for a field (default is DataType.STRING).
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {
    String key();
    DataType type() default DataType.STRING;
}
