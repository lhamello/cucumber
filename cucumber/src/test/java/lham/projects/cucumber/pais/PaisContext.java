package lham.projects.cucumber.pais;

import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.continente.ContinenteBD;
import lham.projects.cucumber.continente.ContinenteFactory;
import lham.projects.cucumber.continente.ContinenteRN;
import lham.projects.cucumber.test.BaseIT;

public class PaisContext extends BaseIT {
	
	protected static ContinenteBD continenteBD;
	protected static ContinenteRN continenteRN;
	private Continente continente;
	
	protected static PaisBD paisBD;
	protected static PaisRN paisRN;
	 
	protected final void iniciarCenario() {
        super.startConnection();
        this.prepararCenario();
    }

    private void prepararCenario() {
    	paisBD = new PaisBD();
    	paisBD.setEntityManager(entityManager);

    	paisRN = new PaisRN();
    	paisRN.setPaisBD(paisBD);
    	paisRN.setDAO(paisBD);
    	
    	continenteBD = new ContinenteBD();
    	continenteBD.setEntityManager(entityManager);
    	
    	continenteRN = new ContinenteRN();
    	continenteRN.setContinenteBD(continenteBD);
    	continenteRN.setDAO(continenteBD);
    }
    
    protected void cadastrarPais(PaisFactory.Template template, Continente continente) {
    	Pais pais = new PaisFactory().criarPais(template);
    	pais.setContinente(continente);    	
        paisRN.incluir(pais);
    }
    
    public Continente getContinente() {
		return continente;
	}

	public void setContinente(Continente continente) {
		this.continente = continente;
	}
	
	protected Continente cadastrarContinente(String template) {
        Continente continente = new ContinenteFactory().criarContinente(template);
        return continenteRN.incluir(continente);
    }


}
