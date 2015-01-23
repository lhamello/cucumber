# language: pt
# encoding: iso-8859-1
Funcionalidade: Pesquisar Regiões
  
  Como um usuário
  Quero pesquisar as regiões
  Para que seja possível localizar uma região

  Esquema do Cenario: Deve pesquisar regiões por filtro existente
    Dado que existam regiões cadastradas
    E eu preencho o filtro <filtro> com um valor válido
    Quando eu efetuo a pesquisa de regiões
    Entao são apresentados os registros correspondentes ao filtro <filtro> informado

    Exemplos: 
      | filtro |
      | nome   |
      | pais   |
      | area   |

  Esquema do Cenario: Deve pesquisar regiões por filtro inexistente
    Dado que existam regiões cadastradas
    E eu preencho o filtro <filtro> com um valor inválido
    Quando eu efetuo a pesquisa de regiões
    Entao nenhum registro é retornado pela pesquisa

    Exemplos: 
      | filtro |
      | nome   |
      | pais   |
      | area   |

  Cenario: Deve pesquisar regiões por todos filtros existentes
    Dado que existam regiões cadastradas
    E eu preencho o filtro nome com um valor válido
    E eu preencho o filtro pais com um valor válido
    E eu preencho o filtro area com um valor válido
    Quando eu efetuo a pesquisa de regiões
    Entao são apresentados os registros correspondentes ao filtro informado

  Cenario: Deve pesquisar região por todos filtros inexistentes
    Dado que existam regiões cadastradas
    E eu preencho o filtro nome com um valor inválido
    E eu preencho o filtro pais com um valor inválido
    E eu preencho o filtro area com um valor inválido
    Quando eu efetuo a pesquisa de regiões
    Entao nenhum registro é retornado pela pesquisa
    
