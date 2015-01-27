package lham.projects.cucumber.regiao;

import java.util.List;

import javax.inject.Inject;

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
	public List<Regiao> find(Regiao filtro) {
		filtro.getPropLista().addOrdem(new Ordem("nomeRegiao"));
		return super.find(filtro);
	}
	
	private void validarCamposObrigatorios(Regiao regiao) {
		if (regiao.getNomeRegiao() == null
				|| regiao.getPais() == null
				|| regiao.getPais().getNome() == null
				|| regiao.getArea() == null
				) {
			throw new RNException("Campos obrigatórios não informados.");
		}
	}
	
	public Regiao consultarUnico(Regiao regiao) {		
    	return regiaoBD.consultarUnico(regiao);
	} 
	
	private void validarDuplicacao(Regiao regiao) {
		Regiao regiaoDuplicada = this.consultarUnico(new Regiao(regiao.getNomeRegiao(), regiao.getPais()));
		
		if (regiaoDuplicada != null) {
			throw new RNException("Região já cadastrada.");
		}
	}
	
	@Override
	public Regiao insert(Regiao regiao) {
		this.validarCamposObrigatorios(regiao);
		this.validarDuplicacao(regiao);
		
		regiao = regiaoBD.insert(regiao);
		return regiao;
    } 
	
	@Override
	public Regiao update(Regiao regiao) {
		this.validarCamposObrigatorios(regiao);
		this.validarDuplicacao(regiao);
		
		regiao = regiaoBD.update(regiao);
        return regiao;
    }
}
