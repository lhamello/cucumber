package lham.projects.cucumber.pais;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import lham.projects.cucumber.infra.AbstractService;

public class PaisRN extends AbstractService<Pais, String> {

	private static final long serialVersionUID = 1L;

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
	public List<Pais> listar(Pais entity) {
		List<Pais> paises = super.listar(entity);
		Collections.sort(paises);
		return paises;
	}
}
