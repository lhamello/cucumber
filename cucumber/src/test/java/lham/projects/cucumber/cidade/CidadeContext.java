package lham.projects.cucumber.cidade;

import lham.projects.cucumber.test.BaseIT;

public class CidadeContext extends BaseIT {

	protected static CidadeRN cidadeRN;

	protected final void iniciarCenario() {
		super.startConnection();
		this.prepararCenario();
	}

	private void prepararCenario() {
		cidadeRN = CidadeRNFactory.criarCidadeRN(entityManager);
	}
}
