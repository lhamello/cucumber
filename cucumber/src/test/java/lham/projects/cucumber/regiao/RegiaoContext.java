package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import lham.projects.cucumber.continente.ContinenteContext;
import lham.projects.cucumber.continente.ContinenteFactory;
import lham.projects.cucumber.estado.EstadoContext;
import lham.projects.cucumber.pais.PaisContext;
import lham.projects.cucumber.pais.PaisFactory;
import lham.projects.cucumber.test.BaseIT;

public class RegiaoContext extends BaseIT {

	protected static ContinenteContext continenteContext;
	protected static PaisContext paisContext;
	private static RegiaoBD regiaoBD;
	protected static RegiaoRN regiaoRN;
	protected static EstadoContext estadoContext;

	protected Regiao filtro;
	protected List<Regiao> lista;
	protected Regiao regiao;
	protected Regiao form;
	protected int regioesCadastradas = 0;
	protected String mensagemErro;
	
	protected final void iniciarCenario() {
        super.startConnection();
        this.prepararCenario();
    }

    public void carreagarRN() {      	
    	regiaoBD = new RegiaoBD();
    	regiaoBD.setEntityManager(entityManager);
    	regiaoRN = new RegiaoRN();
    	regiaoRN.setRegiaoBD(regiaoBD);
    	regiaoRN.setDAO(regiaoBD);
    }

    private void prepararCenario() {    	
    	continenteContext = new ContinenteContext();
    	continenteContext.carregarRN();
    	
    	paisContext = new PaisContext();
    	paisContext.carrearRN();
    	
    	this.carreagarRN();
    	
    	estadoContext = new EstadoContext();
    	estadoContext.carregarRN();
    }
	
	protected Regiao incluir(String template) {
        Regiao regiao = RegiaoFactory.criar(template);
        regiao = regiaoRN.incluir(regiao);
        return regiao;
    }
	
	protected void incluirNoveRegioes() {
		continenteContext.cadastrarContinente(ContinenteFactory.Template.AMS.name());
		
		paisContext.incluir(PaisFactory.Template.BR.name());
		paisContext.incluir(PaisFactory.Template.CHL.name());	

		this.incluir(RegiaoFactory.Template.BR_SUL.toString());
		this.incluir(RegiaoFactory.Template.BR_NORTE.toString());
		this.incluir(RegiaoFactory.Template.BR_SUDESTE.toString());
		this.incluir(RegiaoFactory.Template.BR_NORDESTE.toString());
		this.incluir(RegiaoFactory.Template.BR_CENTRO_OESTE.toString());		

		this.incluir(RegiaoFactory.Template.CHL_SUL.toString());
		this.incluir(RegiaoFactory.Template.CHL_NORTE.toString());
		this.incluir(RegiaoFactory.Template.CHL_LESTE.toString());
		this.incluir(RegiaoFactory.Template.CHL_OESTE.toString());	
		
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
