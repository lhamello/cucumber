package lham.projects.cucumber.cidade;

import lham.projects.cucumber.test.BaseIT;

public class CidadeContext extends BaseIT {

	protected static CidadeRN cidadeRN;

	protected void prepararCenario() {
		this.carregarRN();
	} 
	
    public void carregarRN() {    	
    	cidadeRN = CidadeRNFactory.criarCidadeRN(entityManager);
    }

	protected String pegarCampoComparado(Object ed) {
		return ((Cidade) ed).getId().getNomeCidade();
	}
}
