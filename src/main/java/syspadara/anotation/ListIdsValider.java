package syspadara.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import syspadara.validator.ListIdsValidator;

@Constraint(validatedBy = ListIdsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListIdsValider {
	
	String message() default "Venda com um ID = 0 (ZERO) ou ID = -N (NEGATIVO) encontrado!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
