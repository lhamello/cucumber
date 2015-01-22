package lham.projects.cucumber.regiao;

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
	
	protected void cadastrarContinente(String template) {
        Continente continente = new ContinenteFactory().criarContinente(template);
        continenteRN.insert(continente);
    }
	
	protected void cadastrarPais(String template) {
        Pais pais = new PaisFactory().criarPais(template);
        paisRN.insert(pais);
    }
	
	protected void cadastrarRegiao(String template) {
        Regiao regiao = new RegiaoFactory().criarRegiao(template);
        regiaoRN.insert(regiao);
    }
}
