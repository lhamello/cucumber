package lham.projects.cucumber.regiao;

import lham.projects.cucumber.infra.BaseDAO;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class RegiaoBD extends BaseDAO<Regiao, Long> {

	@Override
	public DetachedCriteria adicionarRestricoes(DetachedCriteria dc, final Regiao filtro) {
		if (filtro.getNomeRegiao() != null) {
			dc.add(Restrictions.eq("nomeRegiao", filtro.getNomeRegiao()));
		}
		if (filtro.getPais() != null && filtro.getPais().getNome() != null) {
			dc.createAlias("pais", "pa");
			dc.add(Restrictions.eq("pa.nome", filtro.getPais().getNome()));
		}
		if (filtro.getArea() != null) {
			dc.add(Restrictions.eq("area", filtro.getArea()));
		}
    	return dc;
    } 
	
	public Regiao consultarUnico(Regiao regiao) {
		if (regiao == null || regiao.getPais() == null) {
			return null;
		}
		final Criteria crit = super.criarCriterio();
		crit.createAlias("pais", "pa");
		crit.add(Restrictions.eq("nomeRegiao", regiao.getNomeRegiao()));
		crit.add(Restrictions.eq("pa.nome", regiao.getPais().getNome()));
    	return (Regiao) crit.uniqueResult();
	}
}
