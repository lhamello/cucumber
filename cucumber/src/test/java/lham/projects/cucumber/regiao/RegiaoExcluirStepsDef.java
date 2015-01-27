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
	
	@Dado("^que quero excluir uma região sem dependências \"(.*?)\"$")
	public void queQueroExcluirUmaRegiãoSemDependências(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^eu efetuo a exclusão da região$")
	public void euEfetuoAExclusãoDaRegião() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^a consulta pelos campos nome e pais não deve retornar dados$")
	public void aConsultaPelosCamposNomeEPaisNãoDeveRetornarDados() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que quero excluir uma região com dependências \"(.*?)\"$")
	public void queQueroExcluirUmaRegiãoComDependências(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
