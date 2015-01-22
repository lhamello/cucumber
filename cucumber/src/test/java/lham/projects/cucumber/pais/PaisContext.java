package lham.projects.cucumber.pais;

import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.continente.ContinenteFactory;
import lham.projects.cucumber.test.BaseIT;

public class PaisContext extends BaseIT {
	
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
    }
    
    protected void cadastrarPais(String template) {
        Pais pais = new PaisFactory().criarPais(template);
        paisRN.insert(pais);
    }

}
