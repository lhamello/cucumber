package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertEquals;
import lham.projects.cucumber.pais.Pais;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;

public class RegiaoPesquisarStepsDef extends RegiaoContext {

	

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
	@Dado("^que existam regi�es cadastradas$")
	public void queExistamRegioesCadastradas() throws Throwable {
		super.cadastrarNoveRegioes();
		filtro = new Regiao();
	}

	@Dado("^eu preencho o filtro nome com um valor v�lido$")
	public void euPreenchoOFiltroNomeComUmValorValido() throws Throwable {
		filtro.setId(new RegiaoPK("Sul", null));
	}

	@Quando("^eu efetuo a pesquisa de regi�es$")
	public void euEfetuoAPesquisaDeRegioes() throws Throwable {
		filtro.getPropLista().setTamanho(super.regioesCadastradas); 
	    lista = regiaoRN.find(filtro);
	}
	
	@Entao("^s�o apresentados os registros correspondentes ao filtro nome informado$")
	public void s�oApresentadosOsRegistrosCorrespondentesAoFiltroNomeInformado() throws Throwable {
		String[] regioesPesquisadas = new String[] {"Sul", "Sul"};
		String mensagem = "S�o apresentados os registros correspondentes ao filtro nome informado";	
		super.verificaLista(regioesPesquisadas, mensagem);
	}

	@Dado("^eu preencho o filtro pais com um valor v�lido$")
	public void euPreenchoOFiltroPaisComUmValorValido() throws Throwable {
		filtro.setId(new RegiaoPK(null, new Pais("brasil")));
	}

	@Entao("^s�o apresentados os registros correspondentes ao filtro pais informado$")
	public void s�oApresentadosOsRegistrosCorrespondentesAoFiltroPaisInformado() throws Throwable {
		String[] regioesPesquisadas = new String[] {"centro-oeste", "Nordeste", "Norte", "sudeste", "Sul"};		
		String mensagem = "S�o apresentados os registros correspondentes ao filtro pais informado";
		super.verificaLista(regioesPesquisadas, mensagem);
	}

	@Dado("^eu preencho o filtro area com um valor v�lido$")
	public void euPreenchoOFiltroAreaComUmValorV�lido() throws Throwable {
		filtro.setArea(2000L);
	}

	@Entao("^s�o apresentados os registros correspondentes ao filtro area informado$")
	public void s�oApresentadosOsRegistrosCorrespondentesAoFiltroAreaInformado() throws Throwable {
		String[] regioesPesquisadas = new String[] {"Leste", "Norte", "Oeste", "Sul"};		
		String mensagem = "S�o apresentados os registros correspondentes ao filtro area informado";
		super.verificaLista(regioesPesquisadas, mensagem);
	}

	@Dado("^eu preencho o filtro nome com um valor inv�lido$")
	public void euPreenchoOFiltroNomeComUmValorInv�lido() throws Throwable {
		filtro.setId(new RegiaoPK("XX", null));
	}

	@Entao("^nenhum registro � retornado pela pesquisa$")
	public void nenhumRegistro�RetornadoPelaPesquisa() throws Throwable {
		assertEquals("Nenhum registro � retornado pela pesquisa", 0L, lista.size());
	}

	@Dado("^eu preencho o filtro pais com um valor inv�lido$")
	public void euPreenchoOFiltroPaisComUmValorInv�lido() throws Throwable {
		filtro.setId(new RegiaoPK(null, new Pais("XX")));
	}

	@Dado("^eu preencho o filtro area com um valor inv�lido$")
	public void euPreenchoOFiltroAreaComUmValorInv�lido() throws Throwable {
		filtro.setArea(3000L);
	}

	@Entao("^s�o apresentados os registros correspondentes ao filtro informado$")
	public void s�oApresentadosOsRegistrosCorrespondentesAoFiltroInformado() throws Throwable {
		String[] regioesPesquisadas = new String[] {"Sul"};
		String mensagem = "S�o apresentados os registros correspondentes ao filtro informado";	
		super.verificaLista(regioesPesquisadas, mensagem);
	}
}
