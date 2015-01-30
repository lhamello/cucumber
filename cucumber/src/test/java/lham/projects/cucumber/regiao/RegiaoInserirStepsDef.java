package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import lham.projects.cucumber.continente.ContinenteFactory;
import lham.projects.cucumber.infra.RNException;
import lham.projects.cucumber.pais.Pais;
import lham.projects.cucumber.pais.PaisFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;

public class RegiaoInserirStepsDef extends RegiaoContext {

	

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
	@Dado("^que quero efetuar o cadastro de uma nova região \"(.*?)\"$")
	public void queQueroEfetuarOCadastroDeUmaNovaRegiao(String template) throws Throwable {
		continenteContext.cadastrarContinente(ContinenteFactory.Template.AMS.name());		
		paisContext.incluir(PaisFactory.Template.BR.name());
	    regiao = RegiaoFactory.criar(template);
	}

	@Quando("^eu efetuo a operação de inserir a região$")
	public void euEfetuoAOperacaoDeInserirARegiao() throws Throwable {
		try {			
			regiaoRN.incluir(regiao);
		} catch (RNException e) {
			mensagemErro = e.getMessage();
		}
	}

	@Entao("^a consulta pelos campos nome e pais deve retornar um registro$")
	public void aConsultaPelosCamposNomeEPaisDeveRetornarUmRegistro() throws Throwable {
	    regiao = regiaoRN.consultarUnico(new Regiao("Sul", new Pais("brasil")));
	    assertNotNull("A  consulta pelos campos nome e pais deve retornar um registro", regiao);
	}

	@Dado("^que quero efetuar o cadastro de um nova região \"(.*?)\"$")
	public void queQueroEfetuarOCadastroDeUmNovaRegiao(String template) throws Throwable {
		continenteContext.cadastrarContinente(ContinenteFactory.Template.AMS.name());		
		paisContext.incluir(PaisFactory.Template.BR.name());
	    regiao = RegiaoFactory.criar(template);
	}

	@Dado("^não preencho o campo nome$")
	public void naoPreenchoOCampoNome() throws Throwable {
		regiao.setNomeRegiao(null);
	}

	@Entao("^devo receber a mensagem \"(.*?)\"$")
	public void devoReceberAMensagem(String mensagemEsperada) throws Throwable {
		assertEquals("Devo receber a mensagem", mensagemEsperada, mensagemErro);
	}

	@Dado("^não preencho o campo pais$")
	public void naoPreenchoOCampoPais() throws Throwable {
		regiao.setPais(null);
	}

	@Dado("^não preencho o campo area$")
	public void naoPreenchoOCampoArea() throws Throwable {
		regiao.setArea(null);
	}

	@Dado("^esta região \"(.*?)\" já esta cadastrada$")
	public void estaRegiaoJaEstaCadastrada(String arg1) throws Throwable {
	    super.incluir(RegiaoFactory.Template.BR_SUL.toString());
	}	
}
