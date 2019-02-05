# syspadara

- Atualização para versao 2.0.0 -:
1- Implementação do VendaProduto para corrigir o "erro" de exibir o estoque do produto ao inves da quantidade vendida quando consultamos uma venda realizada!
2- Removido Spring Security!

- Atualização para versao 2.0.2 -:
1- Renomeado classe PRODUTO para ESTOQUE e conssequentemente seu repository, service e controller.
2- Implementado classe CAIXA e suas respectivas dependencias e regras de negocio.
3- Implementado ALteração do status da venda após ela ser validada por um caixa.

- Atualização para versao 2.2.0 -:
1- Criado Anotações e Validadores.
2- Criado validações validação de criação de uma venda.
3- Criado funções finalizeVenda, isValid e decrementaVenda à Classe VENDA
4- Implementado funções de validação de venda nas classes CAIXA, VENDA e ESTOQUE

- Atualização para versao 2.2.1 -:
1- Adicionado nova verificação de validação de venda