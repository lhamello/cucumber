package lham.projects.cucumber.continente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import lham.projects.cucumber.infra.Ordem;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ContinenteListarStepsDef extends ContinenteContext {

	private Continente filtro;
	private long continentesCadastrados;
	private List<Continente> resposta;
	
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
		resposta = continenteRN.find(filtro);
	}

	@Entao("^devo receber uma lista vazia como resposta$")
	public void devoReceberUmaListaVaziaComoResposta() throws Throwable {
		assertTrue("Devo receber uma lista vazia como resposta.", resposta.isEmpty());
	}

	@Dado("^que existam registros cadastrados no banco$")
	public void queExistamRegistrosCadastradosNoBanco() throws Throwable {
		filtro = new Continente();
		this.cadastrarContinentes();
	}

	@Dado("^nao passo filtro nenhum para a listagem$")
	public void naoPassoFiltroNenhumParaAListagem() throws Throwable {
		resposta = continenteRN.find(filtro);
	}

	@Entao("^devo receber uma pagina da listagem total$")
	public void devoReceberUmaPaginaDaListagemTotal() throws Throwable {
		final int tamPagina = 2;
		assertTrue("Devo receber uma pagina da listagem total.", resposta.size() == tamPagina);
	}

	@Entao("^o numero total de continentes cadastrados$")
	public void oNumeroTotalDeContinentesCadastrados() throws Throwable {
		long tamTotal = continenteRN.count(filtro);
		assertTrue("Devo receber uma pagina da listagem total.", tamTotal == continentesCadastrados);
	}
	
	@Quando("^acesso a listagem de continentes informando ordenacao pelo campo nome$")
	public void acessoAListagemDeContinentesInformandoOrdenacaoPeloCampoNome() throws Throwable {
		Ordem ordem = new Ordem("nome");
		filtro.getPropLista().addOrdem(ordem);
		filtro.getPropLista().setTamanho(6);
		
		resposta = continenteRN.find(filtro);
	}

	@Entao("^devo receber uma listagem com os registros ordenados por nome de forma crescente$")
	public void devoReceberUmaListagemComOsRegistrosOrdenadosPorNomeDeFormaCrescente() throws Throwable {
		String[] array = { "Africa", "America do Norte", "America do Sul", "Asia", "Europa", "Oceania" };
		String prefixo = "Devo receber uma listagem com os registros ordenados por nome de forma crescente (get(";
		String sufixo = ")).";
		int indice = 0;
		
		for (Continente continente : resposta) {
			StringBuilder msgTeste = new StringBuilder(90);
			msgTeste.append(prefixo).append(indice).append(sufixo);
			
			String esperado = array[indice].toLowerCase();
			String atual = continente.getNome().toLowerCase();
			
			assertEquals(msgTeste.toString(), esperado, atual);	
			indice++;
		}
	}

	/*
	 * --------------------------------- métodos privados
	 */

	private void cadastrarContinentes() {
		continentesCadastrados = 6;

		super.cadastrarContinente("oce");
		super.cadastrarContinente("afr");
		super.cadastrarContinente("ams");
		super.cadastrarContinente("eur");
		super.cadastrarContinente("amn");
		super.cadastrarContinente("asi");
	}
}
