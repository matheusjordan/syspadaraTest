package syspadara.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import syspadara.anotations.NotNegative;

public class NotNegativeValidator implements ConstraintValidator<NotNegative, Double>{

	@Override
	public boolean isValid(Double valor, ConstraintValidatorContext valor0) {
		
		return valor < 0;
	}

}
