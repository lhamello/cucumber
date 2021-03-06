# language: pt
# encoding: iso-8859-1
Funcionalidade: Listar Continentes
  
  Como um usu�rio
  Quero listar os paises
  Para que seja poss�vel selecionar um pais a partir da listagem 

  Cenario: Deve retornar uma lista vazia
    Dado que n�o existam registros cadastrados no banco
    Quando eu acesso a listagem de paises
    Entao devo receber uma lista vazia como resposta

  Cenario: Deve retornar todos os registros
    Dado que existam registros cadastrados no banco
    Quando eu acesso a listagem de paises
    Entao devo receber uma listagem com todos os registros

  Cenario: Deve retornar lista ordenada de forma crescente
    Dado que existam registros cadastrados no banco
    Quando eu acesso a listagem de paises
    Entao devo receber uma listagem com os registros ordenados por nome de forma crescente
