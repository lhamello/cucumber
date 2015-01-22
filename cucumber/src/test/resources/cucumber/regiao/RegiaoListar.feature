# language: pt
# encoding: iso-8859-1
Funcionalidade: Listar Regi�es
  
  Como um usu�rio
  Quero listar as regi�es
  Para que seja poss�vel selecionar uma regi�o a partir da listagem

  Cenario: Deve retornar uma lista vazia
    Dado que n�o existam registros cadastrados no banco
    Quando eu acesso a listagem de regi�es
    Entao devo receber uma lista vazia como resposta
    
  Cenario: Deve retornar uma lista paginada
    Dado que existam registros cadastrados no banco
    E n�o passo filtro nenhum para a listagem
	Quando eu acesso a listagem de regi�es
    Entao devo receber uma p�gina da listagem total
    E o numero total de regi�es cadastrados

  Cenario: Deve retornar lista ordenada de forma crescente
    Dado que existam registros cadastrados no banco
    Quando eu acesso a listagem de regi�es sem pagina��o
    Entao devo receber uma listagem com os registros ordenados por nome de forma crescente
