package lham.projects.cucumber.continente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import lham.projects.cucumber.infra.AbstractEntity;

@Entity
@Table(name = "CONTINENTE")
@NamedQueries(value = { @NamedQuery(name = "Continente.findByPk", query = "SELECT c FROM Continente c WHERE c.nome = :pk") })
public class Continente extends AbstractEntity<String> implements Comparable<Continente> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NOME", nullable = false, length = 20)
	@NotBlank
	private String nome;

	@Column(name = "CODIGO", nullable = false, length = 3, unique = true)
	private String codigo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String getPrimaryKey() {
		return this.getNome();
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		this.setNome(primaryKey);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Continente other = (Continente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public int compareTo(Continente continente) {
		String thisNome = StringUtils.stripAccents(this.nome);
		String paramNome = StringUtils.stripAccents(continente.getNome());
		
		return thisNome.toLowerCase().compareTo(paramNome.toLowerCase());
	}
}
