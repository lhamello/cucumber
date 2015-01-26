# language: pt
# encoding: iso-8859-1
Funcionalidade: Inserir Regiões
  
  Como um usuário
  Quero inserir uma região
  Para que seja possível manter um cadastro de regiões

  Cenario: Deve inserir uma região
    Dado que quero efetuar o cadastro de uma nova região "BR_SUL"
    Quando eu efetuo a operação de inserir a região
    Entao a consulta pelos campos nome e pais deve retornar um registro

  Esquema do Cenario: Deve validar campos obrigatórios
    Dado que quero efetuar o cadastro de um nova região "BR_SUL"
    E não preencho o campo <campo obrigatorio>
    Quando eu efetuo a operação de inserir a região
    Entao devo receber a mensagem "Campos obrigatórios não informados."

    Exemplos: 
      | campo obrigatorio |
      | nome              |
      | pais              |
      | area              |

  Cenario: Deve validar região duplicada
    Dado que quero efetuar o cadastro de uma nova região "BR_SUL"
    E esta região "BR_SUL" já esta cadastrada
    Quando eu efetuo a operação de inserir a região
    Entao devo receber a mensagem "Região já cadastrada."
    
