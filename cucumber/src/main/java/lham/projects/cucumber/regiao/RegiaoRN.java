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
	
	private void tratarObrigatoriedade(ConstraintViolationException e) {
		if (e.getMessage().contains("NotNull")) {
			throw new RNException("Campos obrigatórios não informados.");
		} else {
			throw e;
		}
	}
	
	private void tratarDuplicacao(PersistenceException e) {
		if (e.getCause().getCause().toString().contains("integrity constraint violation: unique constraint or index violation")) {
			throw new RNException("Região já cadastrada.");
		} else {
			throw e;
		}
	}
	
	@Override
	public Regiao incluir(Regiao regiao) {		
		try {
			regiao = regiaoBD.incluir(regiao);
		} catch (PersistenceException e) {
			this.tratarDuplicacao(e);		
		} catch (ConstraintViolationException e) {
			this.tratarObrigatoriedade(e);	
		}		
		return regiao;
    } 
	
	@Override
	public Regiao alterar(Regiao regiao) {
		try {
			regiao = regiaoBD.alterar(regiao);
		} catch (PersistenceException e) {
			this.tratarDuplicacao(e);		
		} catch (ConstraintViolationException e) {
			this.tratarObrigatoriedade(e);	
		}		
        return regiao;
    }

	public void excluir(Regiao regiao) {
		try {
			regiaoBD.excluir(regiao);
		} catch (Exception e) {
			throw new RNException("Não foi possivel executar a exclusão. Existem estados cadastrados nesta região.");	
		}
	}
}
