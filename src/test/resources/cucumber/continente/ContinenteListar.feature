# language: pt
# encoding: iso-8859-1
Funcionalidade: Listar Continentes
  
  Como um usuario
  Quero listar os continentes
  Para que seja possivel selecionar um continente a partir da listagem

  Cenario: Deve retornar uma lista vazia
    Dado que nao existam continentes cadastrados
    Quando acesso a listagem de continentes
    Entao devo receber uma lista vazia como resposta

  Cenario: Deve retornar uma lista paginada
    Dado que existam registros cadastrados no banco
    E nao passo filtro nenhum para a listagem
	Quando acesso a listagem de continentes
    Entao devo receber uma pagina da listagem total
    E o numero total de continentes cadastrados

  Cenario: Deve retornar lista ordenada de forma crescente
    Dado que existam registros cadastrados no banco
	Quando acesso a listagem de continentes informando ordenacao pelo campo nome
    Entao devo receber uma listagem com os registros ordenados por nome de forma crescente
