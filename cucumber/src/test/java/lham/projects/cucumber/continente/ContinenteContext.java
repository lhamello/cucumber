package lham.projects.cucumber.continente;

import java.util.List;

import lham.projects.cucumber.test.BaseIT;

public class ContinenteContext extends BaseIT {
	
	private static ContinenteBD continenteBD;
	protected static ContinenteRN continenteRN;

	protected Continente filtro;
	protected List<Continente> lista;

    protected void prepararCenario() {
    	this.carregarRN();
    }

    public void carregarRN() {
    	continenteBD = new ContinenteBD();
    	continenteBD.setEntityManager(entityManager);
    	continenteRN = new ContinenteRN();
    	continenteRN.setContinenteBD(continenteBD);
    	continenteRN.setDAO(continenteBD);
    }
	
	public Continente incluir(String template) {
        Continente continente = ContinenteFactory.criarContinente(template);
        continenteRN.incluir(continente);
        return continente;
    }

    protected void incluirContinentes() {
		qtdRegistros = 6;

		this.incluir(ContinenteFactory.Template.OCE.name());
		this.incluir(ContinenteFactory.Template.AFR.name());
		this.incluir(ContinenteFactory.Template.AMS.name());
		this.incluir(ContinenteFactory.Template.EUR.name());
		this.incluir(ContinenteFactory.Template.AMN.name());
		this.incluir(ContinenteFactory.Template.ASI.name());
	}

	protected String pegarCampoComparado(Object ed) {
		return ((Continente) ed).getNome();
	}
}
