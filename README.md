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

- Atualização para versao 2.3.0 -:
1- Adicionado nova busca dinâmica de produtos no ESTOQUE
2- Melhoramento da lógica do algoritmo de VENDA e ESTOQUE
3- Implementação da paginação de produtos no ESTOQUE
4- Implementação de do pacote Dto de PAGINAÇÃO

- Atualização para versao 2.3.0 -:
1- Adicionado Paginação de vendas

- Atualização para versao 3.1.0 -:
1- Implementado Classe USUARIO e conssequentemente seu repository, service e controller.
2- Implementado LOGGER nos Services de todas as Classes do projeto.
3- Corrigido adversidades oriundas da implantação do LOGGER.
4- Implementado DTO's da classe USUARIO.

- Atualização para versao 3.2.0 -:
1- Implementação básica do SpringSecurity

- Atualização para versao 3.3.0 -:
1- Implementado UserDetails e seu service.
2- Implementado LoginDto.
3- Criado Classe JwtUtil para gerar o token
4- Configurado token no application.properties

- Atualização para versao 3.4.0 -:
1- Implementado filtro de requisições

OBS: Erro de autenticação e de parametros estao ocorrendo,
e nao estao permitindo que eu logue no site! >:C