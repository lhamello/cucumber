package lham.projects.cucumber.regiao;

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
	protected static EstadoContext estadoContext;

	private static RegiaoBD regiaoBD;
	protected static RegiaoRN regiaoRN;
	protected Regiao filtro;
	protected List<Regiao> lista;
	protected Regiao regiao;
	protected Regiao form;

    protected void prepararCenario() {    	
    	continenteContext = new ContinenteContext();
    	continenteContext.carregarRN();
    	
    	paisContext = new PaisContext();
    	paisContext.carregarRN();
    	
    	this.carregarRN();
    	
    	estadoContext = new EstadoContext();
    	estadoContext.carregarRN();
    }

    public void carregarRN() {      	
    	regiaoBD = new RegiaoBD();
    	regiaoBD.setEntityManager(entityManager);
    	regiaoRN = new RegiaoRN();
    	regiaoRN.setRegiaoBD(regiaoBD);
    	regiaoRN.setDAO(regiaoBD);
    }
	
	public Regiao incluir(String template) {
        Regiao regiao = RegiaoFactory.criar(template);
        regiao = regiaoRN.incluir(regiao);
        return regiao;
    }
	
	protected void incluirRegioes() {
		continenteContext.incluir(ContinenteFactory.Template.AMS.name());
		
		paisContext.incluir(PaisFactory.Template.BR.name());
		paisContext.incluir(PaisFactory.Template.CHL.name());	

		this.incluir(RegiaoFactory.Template.BR_SUL.name());
		this.incluir(RegiaoFactory.Template.BR_NORTE.name());
		this.incluir(RegiaoFactory.Template.BR_SUDESTE.name());
		this.incluir(RegiaoFactory.Template.BR_NORDESTE.name());
		this.incluir(RegiaoFactory.Template.BR_CENTRO_OESTE.name());		

		this.incluir(RegiaoFactory.Template.CHL_SUL.name());
		this.incluir(RegiaoFactory.Template.CHL_NORTE.name());
		this.incluir(RegiaoFactory.Template.CHL_LESTE.name());
		this.incluir(RegiaoFactory.Template.CHL_OESTE.name());	
		
		qtdRegistros = 9;
	}

	protected String pegarCampoComparado(Object ed) {
		return ((Regiao) ed).getNomeRegiao();
	}
}
