package lham.projects.cucumber.regiao;

import javax.inject.Inject;

import lham.projects.cucumber.infra.AbstractService;

public class RegiaoRN extends AbstractService<Regiao, RegiaoPK> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RegiaoBD regiaoBD;

	@Override
	public void initDAO() {
		super.setDAO(regiaoBD);
	}

	public void setRegiaoBD(RegiaoBD regiaoBD) {
		this.regiaoBD = regiaoBD;
	}

}
