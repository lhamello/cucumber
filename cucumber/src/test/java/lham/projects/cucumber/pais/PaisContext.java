package lham.projects.cucumber.pais;

import static org.junit.Assert.assertEquals;

import java.util.List;

import lham.projects.cucumber.continente.ContinenteContext;
import lham.projects.cucumber.continente.ContinenteFactory;
import lham.projects.cucumber.test.BaseIT;

public class PaisContext extends BaseIT {
	
	protected static ContinenteContext continenteContext;
	private static PaisBD paisBD;
	protected static PaisRN paisRN;
	
	protected Pais filtro; 
	protected List<Pais> lista;

    protected void prepararCenario() {
    	continenteContext = new ContinenteContext();
    	continenteContext.carregarRN();
    	
    	this.carregarRN();
    } 
	
    public void carregarRN() {    	
    	paisBD = new PaisBD();
    	paisBD.setEntityManager(entityManager);
    	paisRN = new PaisRN();
    	paisRN.setPaisBD(paisBD);
    	paisRN.setDAO(paisBD);
    }
	
	public Pais incluir(String template) {
		Pais pais = PaisFactory.criarPais(template);
		//pais.setContinente(continente);
        pais = paisRN.incluir(pais);
		return pais;
	}

	protected void incluirPaises() {
		qtdRegistros = 2;
		
		continenteContext.incluir(ContinenteFactory.Template.AMS.name());

		this.incluir(PaisFactory.Template.CHL.name());
		this.incluir(PaisFactory.Template.BR.name());
	}
	
	protected void verificaOrdenacao(String[] listaOrdenada, String mensagem) throws Throwable {
		assertEquals("Quantidade correta de registros", listaOrdenada.length, lista.size());			
		mensagem = mensagem + " (get(%s)).";	
		
		for (int i = 0; i < listaOrdenada.length; i++) {
			String esperado = listaOrdenada[i].toUpperCase();
			String retorno = lista.get(i).getNome().toUpperCase();			
			assertEquals(String.format(mensagem, i), esperado, retorno);
		}
	}
}
