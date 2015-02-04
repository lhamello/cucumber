package lham.projects.cucumber.pais;

import static org.junit.Assert.assertTrue;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PaisListarStepsDef extends PaisContext{

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
		lista = paisRN.listar(filtro);
	}

	@Entao("^devo receber uma lista vazia como resposta$")
	public void devoReceberUmaListaVaziaComoResposta() throws Throwable {
		assertTrue("Devo receber uma lista vazia como resposta.", lista.isEmpty());
	}

	@Dado("^que existam registros cadastrados no banco$")
	public void queExistamRegistrosCadastradosNoBanco() throws Throwable {
		incluirPaises();
		filtro = new Pais();
	}

	@Entao("^devo receber uma listagem com todos os registros$")
	public void devoReceberUmaListagemComTodosOsRegistros() throws Throwable {
		lista = paisRN.listar(filtro);
		long tamTotal = lista.size();
		assertTrue("Devo receber uma pagina da listagem total.", tamTotal == qtdRegistros);
	}

	@Entao("^devo receber uma listagem com os registros ordenados por nome de forma crescente$")
	public void devoReceberUmaListagemComOsRegistrosOrdenadosPorNomeDeFormaCrescente() throws Throwable {
		String[] listaOrdenada = new String[] {"Brasil", "Chile"};
		String mensagem = "Devo receber uma listagem com os registros ordenados por nome de forma crescente";
		this.verificaLista(lista, listaOrdenada, mensagem);
	}
}
