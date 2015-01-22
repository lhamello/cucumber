package lham.projects.cucumber.regiao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lham.projects.cucumber.pais.Pais;

@Embeddable
public class RegiaoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NOME", length = 100, nullable = false)
	private String nomeRegiao;

	@JoinColumn(name = "PAIS", nullable = false)
	@ManyToOne
	private Pais pais;

	public RegiaoPK() {
		super();
	}

	public RegiaoPK(String nomeRegiao, Pais pais) {
		super();
		this.nomeRegiao = nomeRegiao;
		this.pais = pais;
	}

	public String getNomeRegiao() {
		return nomeRegiao;
	}

	public void setNomeRegiao(String nomeRegiao) {
		this.nomeRegiao = nomeRegiao;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeRegiao == null) ? 0 : nomeRegiao.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegiaoPK other = (RegiaoPK) obj;
		if (nomeRegiao == null) {
			if (other.nomeRegiao != null)
				return false;
		} else if (!nomeRegiao.equals(other.nomeRegiao))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		return true;
	}

}
