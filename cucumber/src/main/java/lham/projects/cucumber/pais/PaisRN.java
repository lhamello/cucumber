package lham.projects.cucumber.pais;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import lham.projects.cucumber.pais.PaisBD;
import lham.projects.cucumber.continente.Continente;
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
	
	@Override
	public List<Pais> find(Pais entity) {
		List<Pais> paises = super.find(entity);
		Collections.sort(paises);
		return paises;
	}
}
