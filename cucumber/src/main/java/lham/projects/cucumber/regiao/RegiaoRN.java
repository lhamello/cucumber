package lham.projects.cucumber.regiao;

import java.util.List;
import javax.inject.Inject;
import lham.projects.cucumber.infra.AbstractService;
import lham.projects.cucumber.infra.Ordem;
import lham.projects.cucumber.infra.RNException;

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
	
	private void validarCamposObrigatorios(Regiao regiao) {
		if (regiao.getId().getNomeRegiao() == null
				|| regiao.getId().getPais() == null
				|| regiao.getArea() == null) {
			throw new RNException("Campos obrigatórios não informados.");
		}
	}
	
	@Override
	public Regiao insert(Regiao regiao) {
		this.validarCamposObrigatorios(regiao);
		try {
			regiao = regiaoBD.insert(regiao);
		} catch (Exception e) {
			throw new RNException("Região já cadastrada.");
		}
		return regiao;
    }
}
