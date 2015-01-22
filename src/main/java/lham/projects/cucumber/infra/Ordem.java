package lham.projects.cucumber.infra;

import java.io.Serializable;

public class Ordem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String propriedade;
	private boolean asc = true;

	public Ordem(String propriedade) {
		this.propriedade = propriedade;
	}

	public Ordem(String propriedade, boolean asc) {
		this.propriedade = propriedade;
		this.asc = asc;
	}

	public String getPropriedade() {
		return propriedade;
	}

	public boolean isAsc() {
		return asc;
	}

}
