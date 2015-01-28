package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertTrue;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;

public class RegiaoListarStepsDef extends RegiaoContext {
	

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
	
	@Dado("^que não existam registros cadastrados no banco$")
	public void queNaoExistamRegistrosCadastradosNoBanco() throws Throwable {		
		filtro = new Regiao();
	}

	@Quando("^eu acesso a listagem de regiões$")
	public void euAcessoAListagemDeRegioes() throws Throwable {		
		filtro = new Regiao();
		lista = regiaoRN.listar(filtro);
	}

	@Quando("^eu acesso a listagem de regiões sem paginação$")
	public void euAcessoAListagemDeRegioesSemPaginacao() throws Throwable {		
		filtro = new Regiao();
		filtro.getPropLista().setTamanho(super.regioesCadastradas); 
		lista = regiaoRN.listar(filtro);
	}

	@Entao("^devo receber uma lista vazia como resposta$")
	public void devoReceberUmaListaVaziaComoResposta() throws Throwable {
		assertTrue("Devo receber uma lista vazia como resposta.", lista.isEmpty());
	}
	
	@Dado("^que existam registros cadastrados no banco$")
	public void queExistamRegistrosCadastradosNoBanco() throws Throwable {
	    super.cadastrarNoveRegioes();
	}

	@Dado("^não passo filtro nenhum para a listagem$")
	public void naoPassoFiltroNenhumParaAListagem() throws Throwable {
		filtro = new Regiao();
		lista = regiaoRN.listar(filtro);
	}

	@Entao("^devo receber uma página da listagem total$")
	public void devoReceberUmaPaginaDaListagemTotal() throws Throwable {
		final int tamPagina = 2;
		assertTrue("Devo receber uma pagina da listagem total.", lista.size() == tamPagina);
	}

	@Entao("^o numero total de regiões cadastrados$")
	public void oNumeroTotalDeRegioesCadastrados() throws Throwable {
		long tamTotal = regiaoRN.contar(filtro);
		assertTrue("Devo receber uma pagina da listagem total.", tamTotal == super.regioesCadastradas);
	}

	@Entao("^devo receber uma listagem com os registros ordenados por nome de forma crescente$")
	public void devoReceberUmaListagemComOsRegistrosOrdenadosPorNomeDeFormaCrescente() throws Throwable {
		String[] regioesOrdenadas = new String[] {"centro-oeste", "Leste", "Nordeste", "Norte", "Norte", "Oeste", "sudeste", "Sul", "Sul"};
		String mensagem = "Devo receber uma listagem com os registros ordenados por nome de forma crescente";
		this.verificaLista(regioesOrdenadas, mensagem);
	}
}
