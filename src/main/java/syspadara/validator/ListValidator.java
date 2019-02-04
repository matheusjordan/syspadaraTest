package syspadara.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import syspadara.anotation.ListValider;

//http://pipeless.blogspot.com/2008/10/o-algoritmo-de-luhn.html
//http://informacaocomdiversao.blogspot.com/2008/10/resposta-ao-algoritmo-de-luhn.html
//https://gist.github.com/adrianoluis/5043397d378ae506d87366abb0ab4e30
//Define a classe que contêm as regras de validação da anotação...

//Verifica se a lista está vazia e se a lista possui algum id 0
public class ListValidator implements ConstraintValidator<ListValider, List<Long>>{

	@Override
	public boolean isValid(List<Long> vendas, ConstraintValidatorContext context) {
		return (vendas != null) ? (vendas.size() >= 1) : false;
	}
	
}
