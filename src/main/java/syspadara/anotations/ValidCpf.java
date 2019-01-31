package syspadara.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import syspadara.validations.ValidCpfValidator;

@Constraint(validatedBy =  ValidCpfValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCpf {
	
	String message() default "CPF inválido!";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
