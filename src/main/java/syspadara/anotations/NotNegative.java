package syspadara.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import syspadara.validations.NotNegativeValidator;

//http://pipeless.blogspot.com/2008/10/o-algoritmo-de-luhn.html
//http://informacaocomdiversao.blogspot.com/2008/10/resposta-ao-algoritmo-de-luhn.html
//https://gist.github.com/adrianoluis/5043397d378ae506d87366abb0ab4e30
//Define a classe que contêm as regras de validação da anotação...
@Constraint(validatedBy = NotNegativeValidator.class)

//Define onde minha validação será feita ex: em um método, em um atributo, e uma classe e etc...
@Target({ElementType.FIELD, ElementType.PARAMETER})

//Define como ela será executada ex: Em tempo de execução, em tempo de deploy e etc...
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNegative {

	String message() default "VALOR NAO PODE SER NEGATIVO SEU JUMENTO";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
