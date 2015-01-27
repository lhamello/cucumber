package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.infra.RNException;
import lham.projects.cucumber.pais.Pais;
import lham.projects.cucumber.pais.PaisFactory;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;

public class RegiaoExcluirStepsDef extends RegiaoContext {


	/*
	 * --------------------------------- Configura��o
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
	 * --------------------------------- Cen�rios
	 */
	
	@Dado("^que quero excluir uma regi�o sem depend�ncias \"(.*?)\"$")
	public void queQueroExcluirUmaRegi�oSemDepend�ncias(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^eu efetuo a exclus�o da regi�o$")
	public void euEfetuoAExclus�oDaRegi�o() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^a consulta pelos campos nome e pais n�o deve retornar dados$")
	public void aConsultaPelosCamposNomeEPaisN�oDeveRetornarDados() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que quero excluir uma regi�o com depend�ncias \"(.*?)\"$")
	public void queQueroExcluirUmaRegi�oComDepend�ncias(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
