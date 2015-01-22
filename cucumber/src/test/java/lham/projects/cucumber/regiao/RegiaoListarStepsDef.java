package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;

public class RegiaoListarStepsDef extends RegiaoContext {

	private Regiao filtro;
	private List<Regiao> resposta;
	private long regioesCadastradas;
	

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
	public void queNãoExistamRegistrosCadastradosNoBanco() throws Throwable {		
		filtro = new Regiao();
	}

	@Quando("^eu acesso a listagem de regiões$")
	public void euAcessoAListagemDeRegiões() throws Throwable {		
		filtro = new Regiao();
		resposta = regiaoRN.find(filtro);
	}

	@Entao("^devo receber uma lista vazia como resposta$")
	public void devoReceberUmaListaVaziaComoResposta() throws Throwable {
		assertTrue("Devo receber uma lista vazia como resposta.", resposta.isEmpty());
	}
	
	@Dado("^que existam registros cadastrados no banco$")
	public void queExistamRegistrosCadastradosNoBanco() throws Throwable {
	    this.cadastrarRegioes();
	}

	@Dado("^não passo filtro nenhum para a listagem$")
	public void nãoPassoFiltroNenhumParaAListagem() throws Throwable {
		filtro = new Regiao();
		resposta = regiaoRN.find(filtro);
	}

	@Quando("^acesso a listagem de regiões$")
	public void acessoAListagemDeRegiões() throws Throwable {
		filtro = new Regiao();
		resposta = regiaoRN.find(filtro);
	}

	@Entao("^devo receber uma página da listagem total$")
	public void devoReceberUmaPáginaDaListagemTotal() throws Throwable {
		final int tamPagina = 2;
		assertTrue("Devo receber uma pagina da listagem total.", resposta.size() == tamPagina);
	}

	@Entao("^o numero total de regiões cadastrados$")
	public void oNumeroTotalDeRegiõesCadastrados() throws Throwable {
		long tamTotal = regiaoRN.count(filtro);
		assertTrue("Devo receber uma pagina da listagem total.", tamTotal == regioesCadastradas);
	}

	@Entao("^devo receber uma listagem com os registros ordenados por nome de forma crescente$")
	public void devoReceberUmaListagemComOsRegistrosOrdenadosPorNomeDeFormaCrescente() throws Throwable {
		boolean condicao = "Centro-oeste".equalsIgnoreCase(resposta.get(0).getId().getNomeRegiao());
		assertTrue("Devo receber uma listagem com os registros ordenados por nome de forma crescente (get(0)).", condicao);
	}
	
	/*
	 * --------------------------------- métodos privados
	 */

	private void cadastrarRegioes() {
		super.cadastrarContinente("ams");
		
		super.cadastrarPais("br");
		super.cadastrarPais("chl");		
		
		regioesCadastradas = 9;

		super.cadastrarRegiao("br-sul");
		super.cadastrarRegiao("br-norte");
		super.cadastrarRegiao("br-sudeste");
		super.cadastrarRegiao("br-nordeste");
		super.cadastrarRegiao("br-centrooeste");		

		super.cadastrarRegiao("chl-sul");
		super.cadastrarRegiao("chl-norte");
		super.cadastrarRegiao("chl-leste");
		super.cadastrarRegiao("chl-oeste");
	}
}
