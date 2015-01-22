package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.pais.PaisFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;

public class RegiaoListarStepsDef extends RegiaoContext {

	private Regiao filtro;
	private List<Regiao> resposta;
	final private long regioesCadastradas = 9L;
	

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
		resposta = regiaoRN.find(filtro);
	}

	@Quando("^eu acesso a listagem de regiões sem paginação$")
	public void euAcessoAListagemDeRegioesSemPaginacao() throws Throwable {		
		filtro = new Regiao();
		filtro.getPropLista().setTamanho(9); 
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
	public void naoPassoFiltroNenhumParaAListagem() throws Throwable {
		filtro = new Regiao();
		resposta = regiaoRN.find(filtro);
	}

	@Entao("^devo receber uma página da listagem total$")
	public void devoReceberUmaPaginaDaListagemTotal() throws Throwable {
		final int tamPagina = 2;
		assertTrue("Devo receber uma pagina da listagem total.", resposta.size() == tamPagina);
	}

	@Entao("^o numero total de regiões cadastrados$")
	public void oNumeroTotalDeRegioesCadastrados() throws Throwable {
		long tamTotal = regiaoRN.count(filtro);
		assertTrue("Devo receber uma pagina da listagem total.", tamTotal == regioesCadastradas);
	}

	@Entao("^devo receber uma listagem com os registros ordenados por nome de forma crescente$")
	public void devoReceberUmaListagemComOsRegistrosOrdenadosPorNomeDeFormaCrescente() throws Throwable {
		String[] regioesOrdenadas = new String[] {"centro-oeste", "Leste", "Nordeste", "Norte", "Norte", "Oeste", "sudeste", "Sul", "Sul"};
		String mensagem = "Devo receber uma listagem com os registros ordenados por nome de forma crescente (get(%s)).";
		
		for (int i = 0; i < regioesCadastradas; i++) {
			String esperado = regioesOrdenadas[i].toUpperCase();
			String retorno = resposta.get(i).getId().getNomeRegiao().toUpperCase();			
			assertEquals(String.format(mensagem, i), esperado, retorno);
		}
	}
	
	/*
	 * --------------------------------- métodos privados
	 */

	private void cadastrarRegioes() {
		Continente ams = super.cadastrarContinente("ams");
		
		super.cadastrarPais(PaisFactory.Template.BR, ams);
		super.cadastrarPais(PaisFactory.Template.CHL, ams);	

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
