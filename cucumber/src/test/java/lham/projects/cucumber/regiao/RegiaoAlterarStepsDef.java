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
	@Dado("^que quero efetuar uma alteração nos campos de uma região \"(.*?)\"$")
	public void queQueroEfetuarUmaAlteraçãoNosCamposDeUmaRegião(String template) throws Throwable {
		Continente ams = this.cadastrarContinente("ams");
		this.cadastrarPais(PaisFactory.Template.BR, ams);
		chile = this.cadastrarPais(PaisFactory.Template.CHL, ams);		
		
		regiao = this.cadastrarRegiao(template);	
		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_LESTE.toString());
	}
	
	@Dado("^preencho os campos nome e pais com os valores de uma região não cadastrada$")
	public void preenchoOsCamposNomeEPaisComOsValoresDeUmaRegiãoNãoCadastrada() throws Throwable {
		regiao.setNomeRegiao("Sul2");
		regiao.setPais(chile);
		regiao.setArea(3000L);
	}

	@Quando("^eu efetuo a operação de alterar a região$")
	public void euEfetuoAOperaçãoDeAlterarARegião() throws Throwable {
		try {
			regiao = regiaoRN.update(regiao);
		} catch (RNException e) {
			mensagemErro = e.getMessage();
		}
	}

	@Entao("^a consulta pelos campos nome e pais deve retornar um registro com os dados de entrada$")
	public void aConsultaPelosCamposNomeEPaisDeveRetornarUmRegistroComOsDadosDeEntrada() throws Throwable {
		regiao = this.consulta("Sul2", chile);
		assertTrue("A consulta pelos campos nome e pais deve conter os dados de entrada do campo area", 3000L == regiao.getArea());
	}
	
	@Dado("^preencho os campos nome e pais com os mesmos valores de outra região já cadastrada$")
	public void preenchoOsCamposNomeEPaisComOsMesmosValoresDeOutraRegiãoJáCadastrada() throws Throwable {
		regiao.setNomeRegiao("Leste");
		regiao.setPais(chile);
		regiao.setArea(3000L);
	}
	
	@Entao("^eu devo receber a mensagem \"(.*?)\"$")
	public void euDevoReceberAMensagem(String mensagemEsperada) throws Throwable {
		assertEquals("Eu devo receber a mensagem", mensagemEsperada, mensagemErro);
	}
	
//	@Dado("^que quero efetuar uma alteração inválida nos campos de uma região \"(.*?)\"$")
//	public void queQueroEfetuarUmaAlteraçãoInválidaNosCamposDeUmaRegião(String template) throws Throwable {
//		Continente ams = this.cadastrarContinente("ams");
//		this.cadastrarPais(PaisFactory.Template.BR, ams);
//		chile = this.cadastrarPais(PaisFactory.Template.CHL, ams);		
//		
//		regiao = this.cadastrarRegiao(template);	
//		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_LESTE.toString());
//	}

	@Dado("^não preencho o nome$")
	public void nãoPreenchoONome() throws Throwable {
		regiao.setNomeRegiao(null);
	}

	@Dado("^não preencho o pais$")
	public void nãoPreenchoOPais() throws Throwable {
		regiao.setPais(null);
	}

	@Dado("^não preencho o area$")
	public void nãoPreenchoOArea() throws Throwable {
		regiao.setArea(null);
	}
	
}
