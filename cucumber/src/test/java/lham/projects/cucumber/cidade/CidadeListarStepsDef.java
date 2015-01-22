package lham.projects.cucumber.cidade;

import java.util.List;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CidadeListarStepsDef extends CidadeContext {

	private Cidade filtro;
	private long cidadesCadastradas;
	private List<Cidade> resposta;

	/*
	 * --------------------------------- Configuração
	 */

	@Before
	public void initializeScenario() {
		super.iniciarCenario();
	}

	@After
	public void finalizeScenario() {
		super.closeConnection();
	}

	/*
	 * --------------------------------- Cenários
	 */

}
