package lham.projects.cucumber.regiao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import lham.projects.cucumber.infra.AbstractService;
import lham.projects.cucumber.infra.Ordem;
import lham.projects.cucumber.infra.RNException;

public class RegiaoRN extends AbstractService<Regiao, Long> {

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
	public List<Regiao> listar(Regiao filtro) {
		filtro.getPropLista().addOrdem(new Ordem("nomeRegiao"));
		return super.listar(filtro);
	}
	
	public Regiao consultarUnico(Regiao regiao) {		
    	return regiaoBD.consultarUnico(regiao);
	} 
	
	private void tratarRestricaoObrigatoriedade(ConstraintViolationException e) {
		if (e.getMessage().contains("NotNull")) {
			e.printStackTrace();
			throw new RNException("Campos obrigatórios não informados.");
		} else {
			throw e;
		}
	}
	
	private void tratarRestricaoDuplicacao(PersistenceException e) {
		if (e.getCause().getCause().toString().contains("integrity constraint violation: unique constraint or index violation")) {
			e.printStackTrace();
			throw new RNException("Região já cadastrada.");
		} else {
			throw e;
		}
	}
	
	private void tratarRestricaoIntegridade(PersistenceException e) {
		if (e.getCause().getCause().toString().contains("integrity constraint violation: foreign key no action")) {
			e.printStackTrace();
			throw new RNException("Não foi possivel executar a exclusão. Existem estados cadastrados nesta região.");
		} else {
			throw e;
		}
	}
	
	@Override
	public Regiao incluir(Regiao regiao) {		
		try {
			regiao = super.incluir(regiao);
		} catch (PersistenceException e) {
			this.tratarRestricaoDuplicacao(e);		
		} catch (ConstraintViolationException e) {
			this.tratarRestricaoObrigatoriedade(e);	
		}		
		return regiao;
    } 
	
	@Override
	public Regiao alterar(Regiao regiao) {
		try {
			regiao = super.alterar(regiao);
		} catch (PersistenceException e) {
			this.tratarRestricaoDuplicacao(e);		
		} catch (ConstraintViolationException e) {
			this.tratarRestricaoObrigatoriedade(e);	
		}		
        return regiao;
    }

	@Override
	public void excluir(Regiao regiao) {
		try {
			super.excluir(regiao);
		} catch (PersistenceException e) {
			this.tratarRestricaoIntegridade(e);
		}
	}
}
