package lham.projects.cucumber.regiao;

import java.util.List;

import javax.inject.Inject;

import lham.projects.cucumber.infra.AbstractService;
import lham.projects.cucumber.infra.Ordem;

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
	
	@Override
	public List<Regiao> find(Regiao filtro) {
		filtro.getPropLista().addOrdem(new Ordem("id.nomeRegiao"));
		return super.find(filtro);
	}
}
