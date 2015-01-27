package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertEquals;
import lham.projects.cucumber.continente.Continente;
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
	@Dado("^que quero efetuar o cadastro de uma nova regi�o \"(.*?)\"$")
	public void queQueroEfetuarOCadastroDeUmaNovaRegiao(String template) throws Throwable {
		Continente ams = this.cadastrarContinente("ams");		
		this.cadastrarPais(PaisFactory.Template.BR, ams);
	    regiao = new RegiaoFactory().criarRegiao(template);
	}

	@Quando("^eu efetuo a opera��o de inserir a regi�o$")
	public void euEfetuoAOperacaoDeInserirARegiao() throws Throwable {
		try {
			regiaoRN.insert(regiao);
		} catch (RNException e) {
			mensagemErro = e.getMessage();
		}
	}

	@Entao("^a consulta pelos campos nome e pais deve retornar um registro$")
	public void aConsultaPelosCamposNomeEPaisDeveRetornarUmRegistro() throws Throwable {
	    filtro = new Regiao();
	    filtro.setNomeRegiao("Sul");
	    filtro.setPais(new Pais("brasil"));
	    lista = regiaoRN.find(filtro);
	    assertEquals("A  consulta pelos campos nome e pais deve retornar um registro", 1, lista.size());
	}

	@Dado("^que quero efetuar o cadastro de um nova regi�o \"(.*?)\"$")
	public void queQueroEfetuarOCadastroDeUmNovaRegiao(String template) throws Throwable {
		Continente ams = super.cadastrarContinente("ams");		
		super.cadastrarPais(PaisFactory.Template.BR, ams);
	    regiao = new RegiaoFactory().criarRegiao(template);
	}

	@Dado("^n�o preencho o campo nome$")
	public void naoPreenchoOCampoNome() throws Throwable {
		regiao.setNomeRegiao(null);
	}

	@Entao("^devo receber a mensagem \"(.*?)\"$")
	public void devoReceberAMensagem(String mensagemEsperada) throws Throwable {
		assertEquals("Devo receber a mensagem", mensagemEsperada, mensagemErro);
	}

	@Dado("^n�o preencho o campo pais$")
	public void naoPreenchoOCampoPais() throws Throwable {
		regiao.setPais(null);
	}

	@Dado("^n�o preencho o campo area$")
	public void naoPreenchoOCampoArea() throws Throwable {
		regiao.setArea(null);
	}

	@Dado("^esta regi�o \"(.*?)\" j� esta cadastrada$")
	public void estaRegiaoJaEstaCadastrada(String arg1) throws Throwable {
	    super.cadastrarRegiao(RegiaoTemplateEnum.BR_SUL.toString());
	}	
}
