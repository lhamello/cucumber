package lham.projects.cucumber.continente;

import static org.junit.Assert.assertTrue;
import lham.projects.cucumber.infra.Ordem;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ContinenteListarStepsDef extends ContinenteContext {
	
	/*
	 * --------------------------------- Configuração
	 */

	@Before
	public void initializeScenario() {
		super.iniciarCenario();
	}

	@After
	public void finalizeScenario() {
		super.closeConnection();
	}

	/*
	 * --------------------------------- Cenários
	 */

	@Dado("^que nao existam continentes cadastrados$")
	public void queNaoExistamContinentesCadastrados() throws Throwable {
		filtro = new Continente();
	}

	@Quando("^acesso a listagem de continentes$")
	public void acessoAListagemDeContinentes() throws Throwable {
		lista = continenteRN.listar(filtro);
	}

	@Entao("^devo receber uma lista vazia como resposta$")
	public void devoReceberUmaListaVaziaComoResposta() throws Throwable {
		assertTrue("Devo receber uma lista vazia como resposta.", lista.isEmpty());
	}

	@Dado("^que existam registros cadastrados no banco$")
	public void queExistamRegistrosCadastradosNoBanco() throws Throwable {
		filtro = new Continente();
		this.incluirContinentes();
	}

	@Dado("^nao passo filtro nenhum para a listagem$")
	public void naoPassoFiltroNenhumParaAListagem() throws Throwable {
		lista = continenteRN.listar(filtro);
	}

	@Entao("^devo receber uma pagina da listagem total$")
	public void devoReceberUmaPaginaDaListagemTotal() throws Throwable {
		final int tamPagina = 2;
		assertTrue("Devo receber uma pagina da listagem total.", lista.size() == tamPagina);
	}

	@Entao("^o numero total de continentes cadastrados$")
	public void oNumeroTotalDeContinentesCadastrados() throws Throwable {
		long tamTotal = continenteRN.contar(filtro);
		assertTrue("Devo receber uma pagina da listagem total.", tamTotal == qtdRegistros);
	}
	
	@Quando("^acesso a listagem de continentes informando ordenacao pelo campo nome$")
	public void acessoAListagemDeContinentesInformandoOrdenacaoPeloCampoNome() throws Throwable {
		Ordem ordem = new Ordem("nome");
		filtro.getPropLista().addOrdem(ordem);
		filtro.getPropLista().setTamanho(6);
		
		lista = continenteRN.listar(filtro);
	}

	@Entao("^devo receber uma listagem com os registros ordenados por nome de forma crescente$")
	public void devoReceberUmaListagemComOsRegistrosOrdenadosPorNomeDeFormaCrescente() throws Throwable {
		String[] listaOrdenada = new String[] {"Africa", "America do Norte", "America do Sul", "Asia", "Europa", "Oceania"};
		String mensagem = "Devo receber uma listagem com os registros ordenados por nome de forma crescente";
		this.verificaLista(lista, listaOrdenada, mensagem);
	}
}
