package lham.projects.cucumber.continente;

import javax.inject.Inject;

import lham.projects.cucumber.infra.AbstractService;

public class ContinenteRN extends AbstractService<Continente, String> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContinenteBD continenteBD;

	@Override
	public void initDAO() {
		super.setDAO(continenteBD);
	}

	public void setContinenteBD(ContinenteBD continenteBD) {
		this.continenteBD = continenteBD;
	}
}
