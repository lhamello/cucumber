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
	@Dado("^que existam regiões cadastradas$")
	public void queExistamRegioesCadastradas() throws Throwable {
		super.cadastrarNoveRegioes();
		filtro = new Regiao();
	}

	@Dado("^eu preencho o filtro nome com um valor válido$")
	public void euPreenchoOFiltroNomeComUmValorValido() throws Throwable {
		filtro.setId(new RegiaoPK("Sul", null));
	}

	@Quando("^eu efetuo a pesquisa de regiões$")
	public void euEfetuoAPesquisaDeRegioes() throws Throwable {
		filtro.getPropLista().setTamanho(super.regioesCadastradas); 
	    lista = regiaoRN.find(filtro);
	}
	
	@Entao("^são apresentados os registros correspondentes ao filtro nome informado$")
	public void sãoApresentadosOsRegistrosCorrespondentesAoFiltroNomeInformado() throws Throwable {
		String[] regioesPesquisadas = new String[] {"Sul", "Sul"};
		String mensagem = "São apresentados os registros correspondentes ao filtro nome informado";	
		super.verificaLista(regioesPesquisadas, mensagem);
	}

	@Dado("^eu preencho o filtro pais com um valor válido$")
	public void euPreenchoOFiltroPaisComUmValorValido() throws Throwable {
		filtro.setId(new RegiaoPK(null, new Pais("brasil")));
	}

	@Entao("^são apresentados os registros correspondentes ao filtro pais informado$")
	public void sãoApresentadosOsRegistrosCorrespondentesAoFiltroPaisInformado() throws Throwable {
		String[] regioesPesquisadas = new String[] {"centro-oeste", "Nordeste", "Norte", "sudeste", "Sul"};		
		String mensagem = "São apresentados os registros correspondentes ao filtro pais informado";
		super.verificaLista(regioesPesquisadas, mensagem);
	}

	@Dado("^eu preencho o filtro area com um valor válido$")
	public void euPreenchoOFiltroAreaComUmValorVálido() throws Throwable {
		filtro.setArea(2000L);
	}

	@Entao("^são apresentados os registros correspondentes ao filtro area informado$")
	public void sãoApresentadosOsRegistrosCorrespondentesAoFiltroAreaInformado() throws Throwable {
		String[] regioesPesquisadas = new String[] {"Leste", "Norte", "Oeste", "Sul"};		
		String mensagem = "São apresentados os registros correspondentes ao filtro area informado";
		super.verificaLista(regioesPesquisadas, mensagem);
	}

	@Dado("^eu preencho o filtro nome com um valor inválido$")
	public void euPreenchoOFiltroNomeComUmValorInválido() throws Throwable {
		filtro.setId(new RegiaoPK("XX", null));
	}

	@Entao("^nenhum registro é retornado pela pesquisa$")
	public void nenhumRegistroÉRetornadoPelaPesquisa() throws Throwable {
		assertEquals("Nenhum registro é retornado pela pesquisa", 0L, lista.size());
	}

	@Dado("^eu preencho o filtro pais com um valor inválido$")
	public void euPreenchoOFiltroPaisComUmValorInválido() throws Throwable {
		filtro.setId(new RegiaoPK(null, new Pais("XX")));
	}

	@Dado("^eu preencho o filtro area com um valor inválido$")
	public void euPreenchoOFiltroAreaComUmValorInválido() throws Throwable {
		filtro.setArea(3000L);
	}

	@Entao("^são apresentados os registros correspondentes ao filtro informado$")
	public void sãoApresentadosOsRegistrosCorrespondentesAoFiltroInformado() throws Throwable {
		String[] regioesPesquisadas = new String[] {"Sul"};
		String mensagem = "São apresentados os registros correspondentes ao filtro informado";	
		super.verificaLista(regioesPesquisadas, mensagem);
	}
}
