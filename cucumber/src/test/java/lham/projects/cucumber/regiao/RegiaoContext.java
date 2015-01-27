package lham.projects.cucumber.regiao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.continente.ContinenteBD;
import lham.projects.cucumber.continente.ContinenteFactory;
import lham.projects.cucumber.continente.ContinenteRN;
import lham.projects.cucumber.pais.Pais;
import lham.projects.cucumber.pais.PaisBD;
import lham.projects.cucumber.pais.PaisFactory;
import lham.projects.cucumber.pais.PaisRN;
import lham.projects.cucumber.test.BaseIT;

public class RegiaoContext extends BaseIT {

	protected Regiao filtro;
	protected List<Regiao> lista;
	protected Regiao regiao;
	protected Regiao form;
	protected int regioesCadastradas = 0;
	protected String mensagemErro;

	private static ContinenteBD continenteBD;
	private static ContinenteRN continenteRN;
	private static PaisBD paisBD;
	protected static PaisRN paisRN;
	protected static RegiaoBD regiaoBD;
	protected static RegiaoRN regiaoRN;
	
	protected final void iniciarCenario() {
        super.startConnection();
        this.prepararCenario();
    }

    private void prepararCenario() {    	
    	
    	continenteBD = new ContinenteBD();
    	continenteBD.setEntityManager(entityManager);
    	continenteRN = new ContinenteRN();
    	continenteRN.setContinenteBD(continenteBD);
    	continenteRN.setDAO(continenteBD);   	
    	
    	paisBD = new PaisBD();
    	paisBD.setEntityManager(entityManager);
    	paisRN = new PaisRN();
    	paisRN.setPaisBD(paisBD);
    	paisRN.setDAO(paisBD);
    	
    	regiaoBD = new RegiaoBD();
    	regiaoBD.setEntityManager(entityManager);
    	regiaoRN = new RegiaoRN();
    	regiaoRN.setRegiaoBD(regiaoBD);
    	regiaoRN.setDAO(regiaoBD);
    } 
	
	protected Continente cadastrarContinente(String template) {
        Continente continente = new ContinenteFactory().criarContinente(template);
        Continente duplicado = continenteRN.consulta(continente.getNome());
        if (duplicado != null) {
        	continente = duplicado;
        } else {
        	continente = continenteRN.insert(continente);
        }
        return continente;
    }
	
	protected Pais cadastrarPais(PaisFactory.Template template, Continente continente) {
		Pais pais = new PaisFactory().criarPais(template);
		Pais duplicado = paisRN.consulta(pais.getNome());
        if (duplicado != null) {
        	pais = duplicado;
        } else {
        	pais.setContinente(continente);
        	pais = paisRN.insert(pais);
        }		    	
		return pais;
	}
	
	protected Regiao cadastrarRegiao(String template) {
        Regiao regiao = new RegiaoFactory().criarRegiao(template);
        Regiao duplicado = regiaoRN.consultarUnico(regiao);
        if (duplicado != null) {
        	regiao = duplicado;
        } else {
        	regiao = regiaoRN.insert(regiao);
        }		    
        return regiao;
    }
	
	protected void cadastrarNoveRegioes() {
		Continente ams = this.cadastrarContinente("ams");
		
		this.cadastrarPais(PaisFactory.Template.BR, ams);
		this.cadastrarPais(PaisFactory.Template.CHL, ams);	

		this.cadastrarRegiao(RegiaoTemplateEnum.BR_SUL.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_NORTE.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_SUDESTE.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_NORDESTE.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.BR_CENTRO_OESTE.toString());		

		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_SUL.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_NORTE.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_LESTE.toString());
		this.cadastrarRegiao(RegiaoTemplateEnum.CHL_OESTE.toString());
		
		regioesCadastradas = 9;
	}
	
	protected Regiao consulta(String template) {
		Regiao regiao = new RegiaoFactory().criarRegiao(template);
		filtro = new Regiao();
		filtro.setNomeRegiao(regiao.getNomeRegiao());
		filtro.setPais(regiao.getPais());
		lista = regiaoRN.find(filtro);
		return lista.get(0);
	}
	
	protected Regiao consulta(String nome, Pais pais) {
		filtro = new Regiao();
		filtro.setNomeRegiao(nome);
		filtro.setPais(pais);
		lista = regiaoRN.find(filtro);
		return lista.get(0);
	}
	
	protected void verificaLista(String[] regioesEsperadas, String mensagem) throws Throwable {
		assertEquals("Quantidade correta de registros", regioesEsperadas.length, lista.size());			
		mensagem = mensagem + " (get(%s)).";	
		
		for (int i = 0; i < regioesEsperadas.length; i++) {
			String esperado = regioesEsperadas[i].toUpperCase();
			String retorno = lista.get(i).getNomeRegiao().toUpperCase();			
			assertEquals(String.format(mensagem, i), esperado, retorno);
		}
	}
}
