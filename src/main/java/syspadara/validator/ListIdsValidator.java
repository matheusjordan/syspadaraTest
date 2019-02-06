package syspadara.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import syspadara.anotation.ListIdsValider;

public class ListIdsValidator implements ConstraintValidator<ListIdsValider, List<Long>>{


	@Override
	public boolean isValid(List<Long> lista, ConstraintValidatorContext context) {
		return lista.contains(0L) ? false : true;
	}

}
