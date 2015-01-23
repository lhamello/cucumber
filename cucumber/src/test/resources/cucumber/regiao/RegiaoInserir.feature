# language: pt
# encoding: iso-8859-1
Funcionalidade: Alterar Regiões
  
  Como um usuário
  Quero inserir uma região
  Para que seja possível manter um cadastro de regiões

  Cenario: Deve inserir uma região
    Dado que quero efetuar o cadastro de uma nova "regiaoValida"
    Quando eu efetuo a operação de inserir uma região
    Entao a consulta pelos campos nome e pais deve retornar 1 registro

  Esquema do Cenario: Deve validar campos obrigatórios
    Dado que quero efetuar o cadastro de um nova "regiaoValida"
    E não preencho o campo <campo obrigatorio>
    Quando eu efetuo a operacao de inserir uma região
    Entao devo receber a mensagem "Campos obrigatórios não informados."

    Exemplos: 
      | campo obrigatorio |
      | nome              |
      | pais              |
      | area              |

  Cenario: Deve validar região duplicada
    Dado que quero efetuar o cadastro de uma nova "regiaoValida"
    E esta região já esta cadastrada
    Quando eu efetuo a operação de inserir uma região
    Entao devo receber a mensagem "Região já cadastrada."
