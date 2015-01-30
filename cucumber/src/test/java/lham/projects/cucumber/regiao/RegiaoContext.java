package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.continente.ContinenteContext;
import lham.projects.cucumber.estado.EstadoContext;
import lham.projects.cucumber.pais.Pais;
import lham.projects.cucumber.pais.PaisBD;
import lham.projects.cucumber.pais.PaisFactory;
import lham.projects.cucumber.pais.PaisRN;
import lham.projects.cucumber.test.BaseIT;

public class RegiaoContext extends BaseIT {

	protected Regiao filtro;
	protected List<Regiao> lista;
	protected Regiao regiao;
	protected Regiao form;
	protected int regioesCadastradas = 0;
	protected String mensagemErro;

	protected static ContinenteContext continenteContext;
	private static PaisBD paisBD;
	protected static PaisRN paisRN;
	protected static RegiaoBD regiaoBD;
	protected static RegiaoRN regiaoRN;
	protected static EstadoContext estadoContext;
	
	protected final void iniciarCenario() {
        super.startConnection();
        this.prepararCenario();
    }

    private void prepararCenario() {    	
    	
    	continenteContext = new ContinenteContext();
    	continenteContext.carregarRN();
    	
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
    	
    	estadoContext = new EstadoContext();
    	estadoContext.carregarRN();
    } 
	
	protected Pais cadastrarPais(PaisFactory.Template template, Continente continente) {
		Pais pais = new PaisFactory().criarPais(template);
		//pais.setContinente(continente);
        pais = paisRN.incluir(pais);
		return pais;
	}
	
	protected Regiao cadastrarRegiao(String template) {
        Regiao regiao = new RegiaoFactory().criarRegiao(template);
        regiao = regiaoRN.incluir(regiao);
        return regiao;
    }
	
	protected void cadastrarNoveRegioes() {
		Continente ams = continenteContext.cadastrarContinente("ams");
		
		this.cadastrarPais(PaisFactory.Template.BR, ams);
		this.cadastrarPais(PaisFactory.Template.CHL, ams);	

		this.cadastrarRegiao(RegiaoTemplateEnum.BR_SUL.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_NORTE.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_SUDESTE.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_NORDESTE.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_CENTRO_OESTE.toString());		

		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_SUL.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_NORTE.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_LESTE.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_OESTE.toString());	
		
		regioesCadastradas = 9;
	}
	
	protected void verificaLista(String[] regioesEsperadas, String mensagem) throws Throwable {
		assertEquals("Quantidade correta de registros", regioesEsperadas.length, lista.size());			
		mensagem = mensagem + " (get(%s)).";	
		
		for (int i = 0; i < regioesEsperadas.length; i++) {
			String esperado = regioesEsperadas[i].toUpperCase();
			String retorno = lista.get(i).getNomeRegiao().toUpperCase();			
			assertEquals(String.format(mensagem, i), esperado, retorno);
		}
	}
}
