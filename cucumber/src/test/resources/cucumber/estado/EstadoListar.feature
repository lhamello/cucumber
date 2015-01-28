# language: pt
# encoding: iso-8859-1
Funcionalidade: Listar Estados
  
  Como um usuario
  Quero listar as estados
  Para que seja possivel selecionar uma estado a partir da listagem

  Cenario: Deve retornar uma lista vazia
    Dado que nao existam estados cadastradas
    Quando acesso a listagem de estados
    Entao devo receber uma lista vazia como resposta

  Cenario: Deve retornar uma lista paginada
    Dado que existam estados cadastrados
    E nao passo filtro nenhum para a listagem
    Quando acesso a listagem de estados
    Entao devo receber uma pagina da listagem total
    E o numero total de estados cadastradas

  Cenario: Deve retornar lista ordenada de forma crescente
    Dado que existam estados cadastrados no banco
    Quando acesso a listagem de estados informando ordenacao pelo campo nome
    Entao devo receber uma listagem com os registros ordenados por nome de forma crescente
