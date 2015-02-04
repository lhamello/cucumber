package lham.projects.cucumber.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseIT {

	private static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;
	
	protected int qtdRegistros = 0;
	protected String mensagemErro;

	public void startConnection() {
		if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
			entityManagerFactory = Persistence.createEntityManagerFactory("CUCUMBER_TEST");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
		}
	}

	public void closeConnection() {
		if (entityManagerFactory.isOpen()) {

			if (!entityManager.getTransaction().getRollbackOnly()) {
				this.commit();
			} else {
				this.rollback();
			}
		}
	}

	private void commit() {
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
	}

	private void rollback() {
		entityManager.getTransaction().rollback();
		entityManagerFactory.close();
	}
	 
	protected final void iniciarCenario() {
       this.startConnection();
       this.prepararCenario();
    }
	
	protected void verificaLista(List listaRetornada, String[] listaEsperada, String mensagem) throws Throwable {
		assertEquals("Quantidade correta de registros", listaEsperada.length, listaRetornada.size());			
		mensagem = mensagem + " (get(%s)).";
		for (int i = 0; i < listaEsperada.length; i++) {
			String esperado = listaEsperada[i].toUpperCase();
			String comparado = this.pegarCampoComparado(listaRetornada.get(i));
			assertEquals(String.format(mensagem, i), esperado.toUpperCase(), comparado.toUpperCase());
		}
	}

	protected abstract void prepararCenario();
	protected abstract void carregarRN();
	protected abstract String pegarCampoComparado(Object ed);
	
}
