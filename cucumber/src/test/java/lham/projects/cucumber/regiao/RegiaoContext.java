package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.continente.ContinenteBD;
import lham.projects.cucumber.continente.ContinenteFactory;
import lham.projects.cucumber.continente.ContinenteRN;
import lham.projects.cucumber.pais.Pais;
import lham.projects.cucumber.pais.PaisBD;
import lham.projects.cucumber.pais.PaisFactory;
import lham.projects.cucumber.pais.PaisRN;
import lham.projects.cucumber.test.BaseIT;

public class RegiaoContext extends BaseIT {

	protected Regiao filtro;
	protected List<Regiao> lista;
	protected int regioesCadastradas = 0;

	private static ContinenteBD continenteBD;
	private static ContinenteRN continenteRN;
	private static PaisBD paisBD;
	private static PaisRN paisRN;
	protected static RegiaoBD regiaoBD;
	protected static RegiaoRN regiaoRN;
	
	protected final void iniciarCenario() {
        super.startConnection();
        this.prepararCenario();
    }

    private void prepararCenario() {    	
    	
    	continenteBD = new ContinenteBD();
    	continenteBD.setEntityManager(entityManager);
    	continenteRN = new ContinenteRN();
    	continenteRN.setContinenteBD(continenteBD);
    	continenteRN.setDAO(continenteBD);   	
    	
    	paisBD = new PaisBD();
    	paisBD.setEntityManager(entityManager);
    	paisRN = new PaisRN();
    	paisRN.setPaisBD(paisBD);
    	paisRN.setDAO(paisBD);
    	
    	regiaoBD = new RegiaoBD();
    	regiaoBD.setEntityManager(entityManager);
    	regiaoRN = new RegiaoRN();
    	regiaoRN.setRegiaoBD(regiaoBD);
    	regiaoRN.setDAO(regiaoBD);
    } 
	
	protected Continente cadastrarContinente(String template) {
        Continente continente = new ContinenteFactory().criarContinente(template);
        return continenteRN.insert(continente);
    }
	
	protected void cadastrarPais(PaisFactory.Template template, Continente continente) {
		Pais pais = new PaisFactory().criarPais(template);
		pais.setContinente(continente);    	
		paisRN.insert(pais);
	}
	
	protected void cadastrarRegiao(RegiaoTemplateEnum template) {
        Regiao regiao = new RegiaoFactory().criarRegiao(template);
        regiaoRN.insert(regiao);
    }
	
	protected void cadastrarNoveRegioes() {
		Continente ams = this.cadastrarContinente("ams");
		
		this.cadastrarPais(PaisFactory.Template.BR, ams);
		this.cadastrarPais(PaisFactory.Template.CHL, ams);	

		this.cadastrarRegiao(RegiaoTemplateEnum.BR_SUL);
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_NORTE);
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_SUDESTE);
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_NORDESTE);
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_CENTRO_OESTE);		

		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_SUL);
		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_NORTE);
		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_LESTE);
		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_OESTE);
		
		regioesCadastradas = 9;
	}
	
	protected void verificaLista(String[] regioesEsperadas, String mensagem) throws Throwable {
		assertEquals("Quantidade correta de registros", regioesEsperadas.length, lista.size());		
		
		mensagem = mensagem + " (get(%s)).";		
		for (int i = 0; i < regioesEsperadas.length; i++) {
			String esperado = regioesEsperadas[i].toUpperCase();
			String retorno = lista.get(i).getId().getNomeRegiao().toUpperCase();			
			assertEquals(String.format(mensagem, i), esperado, retorno);
		}
	}
}
