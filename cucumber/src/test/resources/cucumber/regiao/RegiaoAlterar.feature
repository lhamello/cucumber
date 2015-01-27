# language: pt
# encoding: iso-8859-1
Funcionalidade: Alterar Regiões
  
  Como um usuário
  Quero alterar uma região
  Para que seja possível manter um cadastro de regiões

  Cenario: Deve validar alteração da região
    Dado que quero efetuar uma alteração nos campos de uma região "BR_SUL"
    E preencho os campos nome e pais com os valores de uma região não cadastrada
    Quando eu efetuo a operação de alterar a região
    Entao a consulta pelos campos nome e pais deve retornar um registro com os dados de entrada

  Esquema do Cenario: Deve validar alteração com campos obrigatórios
    Dado que quero efetuar uma alteração inválida nos campos de uma região "BR_SUL"
    E não preencho o <dado obrigatorio>
    Quando eu efetuo a operação de alterar a região
    Entao eu devo receber a mensagem "Campos obrigatórios não informados."

    Exemplos: 
      | dado obrigatorio |
      | nome             |
      | pais             |
      | area             |

  Cenario: Não deve alterar para uma região já cadastrada
    Dado que quero efetuar uma alteração nos campos de uma região "BR_SUL"
    E preencho os campos nome e pais com os mesmos valores de outra região já cadastrada
    Quando eu efetuo a operação de alterar a região
    Entao eu devo receber a mensagem "Região já cadastrada."
