package lham.projects.cucumber.estado;

import javax.inject.Inject;

import lham.projects.cucumber.infra.AbstractService;

public class EstadoRN extends AbstractService<Estado, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoBD estadoBD;

	@Override
	public void initDAO() {
		super.setDAO(estadoBD);
	}

	public void setEstadoBD(EstadoBD estadoBD) {
		this.estadoBD = estadoBD;
	}

	public Estado consultarUnico(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}
}
