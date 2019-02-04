package syspadara.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import syspadara.validator.ListValidator;

@Constraint(validatedBy = ListValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListValider {
	String message() default "Lista não pode estar vazia";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
