package lham.projects.cucumber.continente;

import lham.projects.cucumber.infra.AbstractService;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ContinenteRN extends AbstractService<Continente, String> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContinenteBD continenteBD;

	@Override
	@PostConstruct//no javaEE7 a anotacao nao eh herdada
	public void initDAO() {
		super.setDAO(continenteBD);
	}

	public void setContinenteBD(ContinenteBD continenteBD) {
		this.continenteBD = continenteBD;
	}
	
	@Override
	public List<Continente> find(Continente entity) {
		List<Continente> continentes = super.find(entity);
		Collections.sort(continentes);
		return continentes;
	}
	
}
