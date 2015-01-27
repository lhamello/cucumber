# language: pt
# encoding: iso-8859-1
Funcionalidade: Alterar Regi�es
  
  Como um usu�rio
  Quero alterar uma regi�o
  Para que seja poss�vel manter um cadastro de regi�es

  Cenario: Deve validar altera��o da regi�o
    Dado que quero efetuar uma altera��o nos campos de uma regi�o "BR_SUL"
    E preencho os campos nome e pais com os valores de uma regi�o n�o cadastrada
    Quando eu efetuo a opera��o de alterar a regi�o
    Entao a consulta pelos campos nome e pais deve retornar um registro com os dados de entrada

  Esquema do Cenario: Deve validar altera��o com campos obrigat�rios
    Dado que quero efetuar uma altera��o inv�lida nos campos de uma regi�o "BR_SUL"
    E n�o preencho o <dado obrigatorio>
    Quando eu efetuo a opera��o de alterar a regi�o
    Entao eu devo receber a mensagem "Campos obrigat�rios n�o informados."

    Exemplos: 
      | dado obrigatorio |
      | nome             |
      | pais             |
      | area             |

  Cenario: N�o deve alterar para uma regi�o j� cadastrada
    Dado que quero efetuar uma altera��o nos campos de uma regi�o "BR_SUL"
    E preencho os campos nome e pais com os mesmos valores de outra regi�o j� cadastrada
    Quando eu efetuo a opera��o de alterar a regi�o
    Entao eu devo receber a mensagem "Regi�o j� cadastrada."
