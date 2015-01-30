package lham.projects.cucumber.estado;

import lham.projects.cucumber.regiao.Regiao;
import lham.projects.cucumber.test.BaseIT;

public class EstadoContext extends BaseIT {
	private static EstadoBD estadoBD;
	private static EstadoRN estadoRN;
	
	protected final void iniciarCenario() {
        super.startConnection();
        this.prepararCenario();
    }

	public void carregarRN() {        	
    	estadoBD = new EstadoBD();
    	estadoBD.setEntityManager(entityManager);
    	estadoRN = new EstadoRN();
    	estadoRN.setEstadoBD(estadoBD);
    	estadoRN.setDAO(estadoBD);
    } 

	private void prepararCenario() {        	
    	this.carregarRN();
    } 
	
	public Estado cadastrarEstado(String template, Regiao regiao) {
		Estado estado = new EstadoFactory().criarEstado(template);
		estado.setRegiao(regiao);
		estado = estadoRN.incluir(estado);
        return estado;
    }
}
