package syspadara.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import syspadara.anotations.ValidCpf;

public class ValidCpfValidator implements ConstraintValidator<ValidCpf, String>{

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext valor) {
		return ValidCpfeCnpj.isValidSsn(cpf);
	}

}
