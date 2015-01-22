# language: pt
# encoding: iso-8859-1
Funcionalidade: Listar Regiões
  
  Como um usuário
  Quero listar as regiões
  Para que seja possível selecionar uma região a partir da listagem

  Cenario: Deve retornar uma lista vazia
    Dado que não existam registros cadastrados no banco
    Quando eu acesso a listagem de regiões
    Entao devo receber uma lista vazia como resposta
    
  Cenario: Deve retornar uma lista paginada
    Dado que existam registros cadastrados no banco
    E não passo filtro nenhum para a listagem
	Quando eu acesso a listagem de regiões
    Entao devo receber uma página da listagem total
    E o numero total de regiões cadastrados

  Cenario: Deve retornar lista ordenada de forma crescente
    Dado que existam registros cadastrados no banco
    Quando eu acesso a listagem de regiões sem paginação
    Entao devo receber uma listagem com os registros ordenados por nome de forma crescente
