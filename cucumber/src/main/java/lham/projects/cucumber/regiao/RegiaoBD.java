package lham.projects.cucumber.regiao;

import lham.projects.cucumber.infra.BaseDAO;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class RegiaoBD extends BaseDAO<Regiao, RegiaoPK> {

	@Override
	public DetachedCriteria addRestrictions(DetachedCriteria dc, final Regiao filtro) {
		if (filtro.getId() != null && filtro.getId().getNomeRegiao() != null) {
			dc.add(Restrictions.eq("id.nomeRegiao", filtro.getId().getNomeRegiao()));
		}
		if (filtro.getId() != null && filtro.getId().getPais() != null && filtro.getId().getPais().getNome() != null) {
			dc.add(Restrictions.eq("id.pais.nome", filtro.getId().getPais().getNome()));
		}
		if (filtro.getArea() != null) {
			dc.add(Restrictions.eq("area", filtro.getArea()));
		}
    	return dc;
    }  
}
