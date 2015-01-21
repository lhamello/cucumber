# language: pt
# encoding: iso-8859-1
Funcionalidade: Inserir Regi�es
  
  Como um usu�rio
  Quero alterar uma regi�o
  Para que seja poss�vel manter um cadastro de regi�es

  Cenario: Deve validar alterac�o da regi�o
    Dado que quero efetuar a atualizacao de uma regi�o "regiaoValida"
    Quando eu efetuo a opera��o de alterar uma regi�o
    Entao a consulta pelo campo nome deve retornar 1 registro com os dados de entrada

  Esquema do Cenario: Deve validar campos obrigat�rios
    Dado que quero efetuar a atualiza��o de uma regi�o "regiaoValida"
    E n�o preencho o <campo obrigatorio>
    Quando eu efetuo a opera��o de alterar uma regi�o
    Entao devo receber a mensagem "Campos obrigat�rios n�o informados."

    Exemplos: 
      | campo obrigatorio |
      | nome              |
      | pais              |
      | area              |

  Esquema do Cenario: N�o deve incluir regi�o duplicada
    Dado que quero efetuar a atualiza��o de uma regi�o "regiaoValida"
    E preencho os campos nome e pais com os mesmos valores de outra regi�o j� cadastrada
    Quando eu efetuo a opera��o de alterar uma regi�o
    Entao devo receber a mensagem "Regi�o j� cadastrada."
