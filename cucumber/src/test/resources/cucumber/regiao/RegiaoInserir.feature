# language: pt
# encoding: iso-8859-1
Funcionalidade: Alterar Regi�es
  
  Como um usu�rio
  Quero inserir uma regi�o
  Para que seja poss�vel manter um cadastro de regi�es

  Cenario: Deve inserir uma regi�o
    Dado que quero efetuar o cadastro de uma nova "regiaoValida"
    Quando eu efetuo a opera��o de inserir uma regi�o
    Entao a consulta pelos campos nome e pais deve retornar 1 registro

  Esquema do Cenario: Deve validar campos obrigat�rios
    Dado que quero efetuar o cadastro de um nova "regiaoValida"
    E n�o preencho o campo <campo obrigatorio>
    Quando eu efetuo a operacao de inserir uma regi�o
    Entao devo receber a mensagem "Campos obrigat�rios n�o informados."

    Exemplos: 
      | campo obrigatorio |
      | nome              |
      | pais              |
      | area              |

  Cenario: Deve validar regi�o duplicada
    Dado que quero efetuar o cadastro de uma nova "regiaoValida"
    E esta regi�o j� esta cadastrada
    Quando eu efetuo a opera��o de inserir uma regi�o
    Entao devo receber a mensagem "Regi�o j� cadastrada."
