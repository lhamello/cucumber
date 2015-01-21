# language: pt
# encoding: iso-8859-1
Funcionalidade: Pesquisar Regi�es
  
  Como um usu�rio
  Quero pesquisar as regi�es
  Para que seja poss�vel localizar uma regi�o

  Esquema do Cenario: Deve pesquisar regi�es por filtro existente
    Dado que existam regi�es cadastradas
    E preencho o <filtro> com um valor v�lido
    Quando eu efetuo a pesquisa de regi�es
    Entao s�o apresentados os registros correspondentes ao filtro informado

    Exemplos: 
      | filtro |
      | nome   |
      | pais   |
      | area   |

  Esquema do Cenario: Deve pesquisar regi�es por filtro inexistente
    Dado que existam regi�es cadastradas
    E preencho o <filtro> com um valor inv�lido
    Quando eu efetuo a pesquisa de regi�es
    Entao nenhum registro � retornado pela pesquisa

    Exemplos: 
      | filtro |
      | nome   |
      | pais   |
      | area   |

  Cenario: Deve pesquisar regi�o por todos filtros existentes
    Dado que existam regi�es cadastradas
    E preencho o filtro nome com um valor v�lido
    E preencho o filtro pais com um valor v�lido
    E preencho o filtro area com um valor v�lido
    Quando eu efetuo a pesquisa de regi�es
    Entao s�o apresentados os registros correspondentes ao filtro informado

  Cenario: Deve pesquisar regi�o por todos filtros inexistentes
    Dado que existam regi�es cadastradas
    E preencho o filtro nome com um valor inv�lido
    E preencho o filtro pais com um valor inv�lido
    E preencho o filtro area com um valor inv�lido
    Quando eu efetuo a pesquisa de regi�es
    Entao nenhum registro � retornado pela pesquisa
    
