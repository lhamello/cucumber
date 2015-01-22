package lham.projects.cucumber.pais;

import javax.inject.Inject;

import lham.projects.cucumber.pais.PaisBD;
import lham.projects.cucumber.infra.AbstractService;

public class PaisRN extends AbstractService<Pais, String> {

	@Inject 
	private PaisBD paisBD;
	
	@Override
	public void initDAO() {
		super.setDAO(paisBD);
	}
	
	public void setPaisBD(PaisBD paisBD) {
		this.paisBD = paisBD;
	}
}
