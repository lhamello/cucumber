package lham.projects.cucumber.regiao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;

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
	
	@Override
	public Regiao insert(Regiao regiao) {
		try {
			regiao = regiaoBD.insert(regiao);
			
		} catch (EntityExistsException e) {
			throw new RNException("Região já cadastrada.");
			
		} catch (PersistenceException e) {
			Throwable causa = e.getCause().getCause();
			if (causa != null && causa.toString().contains("integrity constraint violation: NOT NULL check constraint")) {
				throw new RNException("Campos obrigatórios não informados.");
			}			
		}
		return regiao;
    }
}
