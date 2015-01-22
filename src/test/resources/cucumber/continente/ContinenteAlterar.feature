# language: pt
# encoding: iso-8859-1
Funcionalidade: Inserir Continentes
  
  Como um usuário
  Quero alterar um continente
  Para que seja possível manter um cadastro de continentes

  Cenario: Deve validar alteracao do continente
    Dado que quero efetuar a atualizacao de um continente "continenteValido"
    Quando eu efetuo a operacao de alterar um continente
    Entao a consulta pelo campo nome deve retornar 1 registro com os dados de entrada

  Esquema do Cenario: Deve validar campos obrigatorios
    Dado que quero efetuar a atualizacao de um continente "continenteValido"
    E nao preencho o <campo obrigatorio>
    Quando eu efetuo a operacao de alterar um continente
    Entao devo receber a mensagem "Campos obrigatórios não informados."

    Exemplos: 
      | campo obrigatorio |
      | nome              |
      | codigo            |

  Esquema do Cenario: Nao deve incluir continente duplicado
    Dado que quero efetuar a atualizacao de um continente "continenteValido"
    E preencho o <campo> com o mesmo valor de outro continente ja cadastrado
    Quando eu efetuo a operacao de alterar um continente
    Entao devo receber a mensagem "Continente ja cadastrado."

    Exemplos: 
      | campo  |
      | nome   |
      | codigo |
