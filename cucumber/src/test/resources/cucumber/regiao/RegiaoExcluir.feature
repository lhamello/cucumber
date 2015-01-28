# language: pt
# encoding: iso-8859-1
Funcionalidade: Excluir Regiões
  
  Como um usuário
  Quero excluir uma região
  Para que seja possível manter um cadastro de regiões

  Cenario: Deve excluir uma região sem dependências
    Dado que quero excluir uma região sem dependências "BR_NORTE"
    Quando eu efetuo a exclusão da região
    Entao a consulta pelos campos nome e pais não deve retornar dados

  Cenario: Não deve excluir uma região com dependências
    Dado que quero excluir uma região com dependências "BR_SUL"
    Quando eu efetuo a exclusão da região
    Entao eu devo receber a seguinte mensagem "Não foi possivel executar a exclusão. Existem estados cadastrados nesta região."
