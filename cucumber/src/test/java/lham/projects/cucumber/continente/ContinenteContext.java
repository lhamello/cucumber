package lham.projects.cucumber.continente;

import java.util.List;

import lham.projects.cucumber.test.BaseIT;

public class ContinenteContext extends BaseIT {
	
	private static ContinenteBD continenteBD;
	protected static ContinenteRN continenteRN;

	protected Continente filtro;
	protected long continentesCadastrados;
	protected List<Continente> resposta;
	
	protected final void iniciarCenario() {
        super.startConnection();
        this.prepararCenario();
    }
	
	public Continente cadastrarContinente(String template) {
        Continente continente = ContinenteFactory.criarContinente(template);
        continenteRN.incluir(continente);
        return continente;
    }

    public void carregarRN() {
    	continenteBD = new ContinenteBD();
    	continenteBD.setEntityManager(entityManager);

    	continenteRN = new ContinenteRN();
    	continenteRN.setContinenteBD(continenteBD);
    	continenteRN.setDAO(continenteBD);
    }

    private void prepararCenario() {
    	this.carregarRN();
    }

    protected void cadastrarContinentes() {
		continentesCadastrados = 6;

		this.cadastrarContinente(ContinenteFactory.Template.OCE.name());
		this.cadastrarContinente(ContinenteFactory.Template.AFR.name());
		this.cadastrarContinente(ContinenteFactory.Template.AMS.name());
		this.cadastrarContinente(ContinenteFactory.Template.EUR.name());
		this.cadastrarContinente(ContinenteFactory.Template.AMN.name());
		this.cadastrarContinente(ContinenteFactory.Template.ASI.name());
	}
}
