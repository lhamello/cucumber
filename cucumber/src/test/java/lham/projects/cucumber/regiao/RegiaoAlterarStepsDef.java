package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.infra.RNException;
import lham.projects.cucumber.pais.Pais;
import lham.projects.cucumber.pais.PaisFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;

public class RegiaoAlterarStepsDef extends RegiaoContext {

	private Pais chile;

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
	@Dado("^que quero efetuar uma altera��o nos campos de uma regi�o \"(.*?)\"$")
	public void queQueroEfetuarUmaAlteracaoNosCamposDeUmaRegiao(String template) throws Throwable {			
		Continente ams = this.cadastrarContinente("ams");
		this.cadastrarPais(PaisFactory.Template.BR, ams);
		chile = this.cadastrarPais(PaisFactory.Template.CHL, ams);
		
		regiao = this.cadastrarRegiao(template);		
	}
	
	@Dado("^preencho os campos nome e pais com os valores de uma regi�o n�o cadastrada$")
	public void preenchoOsCamposNomeEPaisComOsValoresDeUmaRegiaoNaoCadastrada() throws Throwable {
		regiao.setNomeRegiao("Sul2");
		regiao.setPais(chile);
		regiao.setArea(3000L);
	}

	@Quando("^eu efetuo a opera��o de alterar a regi�o$")
	public void euEfetuoAOperacaoDeAlterarARegiao() throws Throwable {
		try {
			regiao = regiaoRN.update(regiao);
		} catch (RNException e) {
			mensagemErro = e.getMessage();
			entityManager.getTransaction().setRollbackOnly();
		}
	}

	@Entao("^a consulta pelos campos nome e pais deve retornar um registro com os dados de entrada$")
	public void aConsultaPelosCamposNomeEPaisDeveRetornarUmRegistroComOsDadosDeEntrada() throws Throwable {
		regiao = regiaoRN.consultarUnico(new Regiao("Sul2", chile));
		assertTrue("A consulta pelos campos nome e pais deve conter os dados de entrada do campo area", 3000L == regiao.getArea());
	}
	
	@Dado("^preencho os campos nome e pais com os mesmos valores de outra regi�o j� cadastrada$")
	public void preenchoOsCamposNomeEPaisComOsMesmosValoresDeOutraRegiaoJaCadastrada() throws Throwable {
		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_LESTE.toString());
		
		regiao.setNomeRegiao("Leste");
		regiao.setPais(chile);
		regiao.setArea(3000L);
	}
	
	@Entao("^eu devo receber a mensagem \"(.*?)\"$")
	public void euDevoReceberAMensagem(String mensagemEsperada) throws Throwable {
		assertEquals("Eu devo receber a mensagem", mensagemEsperada, mensagemErro);
	}

	@Dado("^n�o informo o campo nome$")
	public void naoInformoOCampoNome() throws Throwable {
		regiao.setNomeRegiao(null);
	}

	@Dado("^n�o informo o campo pais$")
	public void naoInformoOCampoPais() throws Throwable {
		regiao.setPais(null);
	}

	@Dado("^n�o informo o campo area$")
	public void naoInformoOCampoArea() throws Throwable {
		regiao.setArea(null);
	}	
}
