package lham.projects.cucumber.pais;

import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.continente.ContinenteContext;
import lham.projects.cucumber.test.BaseIT;

public class PaisContext extends BaseIT {
	
	protected static ContinenteContext continenteContext;
	private static PaisBD paisBD;
	protected static PaisRN paisRN;
	private Continente continente;	
	 
	protected final void iniciarCenario() {
        super.startConnection();
        this.prepararCenario();
    }
	
    public void carrearRN() {    	
    	paisBD = new PaisBD();
    	paisBD.setEntityManager(entityManager);
    	paisRN = new PaisRN();
    	paisRN.setPaisBD(paisBD);
    	paisRN.setDAO(paisBD);
    }

    private void prepararCenario() {
    	continenteContext = new ContinenteContext();
    	continenteContext.carregarRN();
    	
    	this.carrearRN();
    } 
	
	public Pais incluir(PaisFactory.Template template) {
		Pais pais = new PaisFactory().criarPais(template);
		//pais.setContinente(continente);
        pais = paisRN.incluir(pais);
		return pais;
	}
    
    public Continente getContinente() {
		return continente;
	}

	public void setContinente(Continente continente) {
		this.continente = continente;
	}
}
