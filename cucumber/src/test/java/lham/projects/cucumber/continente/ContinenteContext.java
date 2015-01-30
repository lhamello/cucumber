package lham.projects.cucumber.continente;

import lham.projects.cucumber.test.BaseIT;

public class ContinenteContext extends BaseIT {
	
	private static ContinenteBD continenteBD;
	protected static ContinenteRN continenteRN;
	
	protected final void iniciarCenario() {
        super.startConnection();
        this.prepararCenario();
    }
	
	public Continente cadastrarContinente(String template) {
        Continente continente = new ContinenteFactory().criarContinente(template);
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
}
