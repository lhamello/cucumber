package lham.projects.cucumber.infra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PropLista implements Serializable {

	private static final long serialVersionUID = 1L;

	private int inicio;
	private int tamanho;
	private Map<String, Object> filtros;
	private List<Ordem> ordem;

	public PropLista(int inicio, int tamanho) {
		super();
		this.inicio = inicio;
		this.tamanho = tamanho;
		this.ordem = new LinkedList<>();
	}

	public PropLista() {
		this.filtros = new HashMap<>();
		this.ordem = new ArrayList<>();
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public Map<String, Object> getFiltros() {
		return filtros;
	}

	public List<Ordem> getOrdem() {
		return ordem;
	}

	public void addOrdem(Ordem ordem) {
		this.ordem.add(ordem);
	}
	
}
