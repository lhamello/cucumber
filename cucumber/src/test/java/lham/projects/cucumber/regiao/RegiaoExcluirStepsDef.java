package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
	public void queQueroExcluirUmaRegiaoSemDependencias(String template) throws Throwable {
	    this.cadastrarNoveRegioes();
	    filtro = new RegiaoFactory().criarRegiao(template);
	    regiao = regiaoRN.consultarUnico(filtro);
	}

	@Quando("^eu efetuo a exclusão da região$")
	public void euEfetuoAExclusaoDaRegiao() throws Throwable {
	    try {
	    	regiaoRN.excluir(regiao);
	    } catch (RNException e) {
	    	mensagemErro = e.getMessage();
	    }
	}

	@Entao("^a consulta pelos campos nome e pais não deve retornar dados$")
	public void aConsultaPelosCamposNomeEPaisNaoDeveRetornarDados() throws Throwable {
		regiao = regiaoRN.consultarUnico(filtro);
		assertNull("A consulta pelos campos nome e pais não deve retornar dados", regiao);		
	}

	@Dado("^que quero excluir uma região com dependências \"(.*?)\"$")
	public void queQueroExcluirUmaRegiaoComDependencias(String template) throws Throwable {
		this.cadastrarNoveRegioes();
	    filtro = new RegiaoFactory().criarRegiao(template);
	    regiao = regiaoRN.consultarUnico(filtro);
	}
}
