# language: pt
# encoding: iso-8859-1
Funcionalidade: Inserir Regi�es
  
  Como um usu�rio
  Quero inserir uma regi�o
  Para que seja poss�vel manter um cadastro de regi�es

  Cenario: Deve inserir uma regi�o
    Dado que quero efetuar o cadastro de uma nova regi�o "BR_SUL"
    Quando eu efetuo a opera��o de inserir a regi�o
    Entao a consulta pelos campos nome e pais deve retornar um registro

  Esquema do Cenario: Deve validar campos obrigat�rios
    Dado que quero efetuar o cadastro de um nova regi�o "BR_SUL"
    E n�o preencho o campo <campo obrigatorio>
    Quando eu efetuo a opera��o de inserir a regi�o
    Entao devo receber a mensagem "Campos obrigat�rios n�o informados."

    Exemplos: 
      | campo obrigatorio |
      | nome              |
      | pais              |
      | area              |

  Cenario: Deve validar regi�o duplicada
    Dado que quero efetuar o cadastro de uma nova regi�o "BR_SUL"
    E esta regi�o "BR_SUL" j� esta cadastrada
    Quando eu efetuo a opera��o de inserir a regi�o
    Entao devo receber a mensagem "Regi�o j� cadastrada."
    
