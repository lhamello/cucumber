# language: pt
# encoding: iso-8859-1
Funcionalidade: Alterar Continentes
  
  Como um usuário
  Quero inserir um continente
  Para que seja possível manter um cadastro de continentes

  Cenario: Deve inserir um continente
    Dado que quero efetuar o cadastro de um novo "continenteValido"
    Quando eu efetuo a operacao de inserir um continente
    Entao a consulta pelo campo nome deve retornar 1 registro

  Esquema do Cenario: Deve validar campos obrigatorios
    Dado que quero efetuar o cadastro de um novo "continenteValido"
    E nao preencho o campo <campo obrigatorio>
    Quando eu efetuo a operacao de inserir um continente
    Entao devo receber a mensagem "Campos obrigatórios não informados."

    Exemplos: 
      | campo obrigatorio |
      | nome              |
      | codigo            |

  Cenario: Deve validar continente duplicado
    Dado que quero efetuar o cadastro de um novo "continenteValido"
    E este continente ja esta cadastrado
    Quando eu efetuo a operacao de inserir um continente
    Entao devo receber a mensagem "Continente ja cadastrado."
