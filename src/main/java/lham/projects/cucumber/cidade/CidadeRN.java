package lham.projects.cucumber.cidade;

import javax.inject.Inject;

import lham.projects.cucumber.infra.AbstractService;

public class CidadeRN extends AbstractService<Cidade, CidadePK> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CidadeBD cidadeBD;

	@Override
	public void initDAO() {
		super.setDAO(cidadeBD);
	}

	public void setContinenteBD(CidadeBD cidadeBD) {
		this.cidadeBD = cidadeBD;
	}

}
