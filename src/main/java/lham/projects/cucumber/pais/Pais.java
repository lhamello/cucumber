package lham.projects.cucumber.pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lham.projects.cucumber.continente.Continente;
import lham.projects.cucumber.infra.AbstractEntity;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "PAIS")
@NamedQueries(value = { @NamedQuery(name = "Pais.findByPk", query = "SELECT p FROM Pais p WHERE p.nome = :pk") })
public class Pais extends AbstractEntity<String> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NOME", nullable = false, length = 60)
	@NotBlank
	private String nome; 

	@JoinColumn(name = "CONTINENTE", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Continente continente;
	
	@Column(name = "CODIGO", nullable = false, length = 3, unique = true)
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Pais other = (Pais) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}

