# language: pt
# encoding: iso-8859-1
Funcionalidade: Listar Cidades
  
  Como um usuario
  Quero listar as cidades
  Para que seja possivel selecionar uma cidade a partir da listagem

  Cenario: Deve retornar uma lista vazia
    Dado que nao existam cidades cadastradas
    Quando acesso a listagem de cidades
    Entao devo receber uma lista vazia como resposta

  Cenario: Deve retornar uma lista paginada
    Dado que existam cidades cadastrados
    E nao passo filtro nenhum para a listagem
    Quando acesso a listagem de cidades
    Entao devo receber uma pagina da listagem total
    E o numero total de cidades cadastradas

  Cenario: Deve retornar lista ordenada de forma crescente
    Dado que existam cidades cadastrados no banco
    Quando acesso a listagem de cidades informando ordenacao pelo campo nome
    Entao devo receber uma listagem com os registros ordenados por nome de forma crescente
