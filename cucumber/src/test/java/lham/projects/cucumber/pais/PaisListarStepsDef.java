package lham.projects.cucumber.pais;

import static org.junit.Assert.assertTrue;

import java.util.List;

import lham.projects.cucumber.continente.Continente;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PaisListarStepsDef extends PaisContext{
	
	private Pais filtro; 
	private List<Pais> resposta;
	private long paisesCadastrados;

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
	    filtro = new Pais();
	}

	@Quando("^eu acesso a listagem de paises$")
	public void euAcessoAListagemDePaises() throws Throwable {
		resposta = paisRN.find(filtro);
	}

	@Entao("^devo receber uma lista vazia como resposta$")
	public void devoReceberUmaListaVaziaComoResposta() throws Throwable {
		assertTrue("Devo receber uma lista vazia como resposta.", resposta.isEmpty());
	}

	@Dado("^que existam registros cadastrados no banco$")
	public void queExistamRegistrosCadastradosNoBanco() throws Throwable {
		cadastrarPaises();
		filtro = new Pais();
	}

	@Entao("^devo receber uma listagem com todos os registros$")
	public void devoReceberUmaListagemComTodosOsRegistros() throws Throwable {
		resposta = paisRN.find(filtro);
		long tamTotal = resposta.size();
		assertTrue("Devo receber uma pagina da listagem total.", tamTotal == paisesCadastrados);
	}

	@Entao("^devo receber uma listagem com os registros ordenados por nome de forma crescente$")
	public void devoReceberUmaListagemComOsRegistrosOrdenadosPorNomeDeFormaCrescente() throws Throwable {
		resposta = paisRN.find(filtro);
		assertTrue("Devo receber uma listagem com os registros ordenados por nome de forma crescente.",				
				resposta.get(0).getCodigo().equals("BR"));
		assertTrue("Devo receber uma listagem com os registros ordenados por nome de forma crescente.", 
				resposta.get(1).getCodigo().equals("CHL"));
	}

	/*
	 * --------------------------------- métodos privados
	 */

	private void cadastrarPaises() {
		paisesCadastrados = 2;

		super.cadastrarPais(PaisFactory.Template.CHL);
		super.cadastrarPais(PaisFactory.Template.BR);
	}
}
