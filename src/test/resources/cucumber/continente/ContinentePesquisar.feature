# language: pt
# encoding: iso-8859-1
Funcionalidade: Pesquisar Continentes
  
  Como um usuário
  Quero pesquisar os continentes
  Para que seja possível localizar um continente

  Esquema do Cenario: Deve pesquisar continentes por filtro existente
    Dado que existam continentes cadastrados
    E preencho o <filtro> com um valor valido
    Quando eu efetuo a pesquisa de continentes
    Entao são apresentados os registros correspondentes ao filtro informado

    Exemplos: 
      | filtro |
      | nome   |
      | codigo |

  Esquema do Cenario: Deve pesquisar continentes por filtro inexistente
    Dado que existam continentes cadastrados
    E preencho o <filtro> com um valor invalido
    Quando eu efetuo a pesquisa de continentes
    Entao nenhum registro e retornado pela pesquisa

    Exemplos: 
      | filtro |
      | nome   |
      | codigo |

  Cenario: Deve pesquisar continente por todos filtros existentes
    Dado que existam continentes cadastrados
    E preencho o filtro nome com um valor valido
    E preencho o filtro codigo com um valor valido
    Quando eu efetuo a pesquisa de continentes
    Entao são apresentados os registros correspondentes ao filtro informado

  Cenario: Deve pesquisar continente por todos filtros inexistentes
    Dado que existam continentes cadastrados
    E preencho o filtro nome com um valor invalido
    E preencho o filtro codigo com um valor invalido
    Quando eu efetuo a pesquisa de continentes
    Entao nenhum registro e retornado pela pesquisa
