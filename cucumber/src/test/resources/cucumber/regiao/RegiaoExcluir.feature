# language: pt
# encoding: iso-8859-1
Funcionalidade: Excluir Regi�es
  
  Como um usu�rio
  Quero excluir uma regi�o
  Para que seja poss�vel manter um cadastro de regi�es

  Cenario: Deve excluir uma regi�o sem depend�ncias
    Dado que quero excluir uma regi�o sem depend�ncias "BR_NORTE"
    Quando eu efetuo a exclus�o da regi�o
    Entao a consulta pelos campos nome e pais n�o deve retornar dados

  Cenario: N�o deve excluir uma regi�o com depend�ncias
    Dado que quero excluir uma regi�o com depend�ncias "BR_SUL"
    Quando eu efetuo a exclus�o da regi�o
    Entao eu devo receber a seguinte mensagem "N�o foi possivel executar a exclus�o. Existem estados cadastrados nesta regi�o."
