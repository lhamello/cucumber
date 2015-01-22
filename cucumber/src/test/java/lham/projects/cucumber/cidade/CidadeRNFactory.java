package lham.projects.cucumber.cidade;

import javax.persistence.EntityManager;

public class CidadeRNFactory {

	public static CidadeRN criarCidadeRN(EntityManager entityManager) {
		CidadeBD cidadeBD = new CidadeBD();
		cidadeBD.setEntityManager(entityManager);

		CidadeRN cidadeRN = new CidadeRN();
		cidadeRN.setContinenteBD(cidadeBD);
		cidadeRN.setDAO(cidadeBD);

		return cidadeRN;
	}
}
