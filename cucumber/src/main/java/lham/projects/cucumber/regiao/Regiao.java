package lham.projects.cucumber.regiao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lham.projects.cucumber.infra.AbstractEntity;

@Entity
@Table(name = "REGIAO")
@NamedQueries(value = { @NamedQuery(name = "Regiao.findByPk", query = "SELECT r FROM Regiao r WHERE r.id = :pk") })
public class Regiao extends AbstractEntity<RegiaoPK> {

	private static final long serialVersionUID = 1L;

	@Id
	private RegiaoPK id;
	
	@Column(name="area", nullable=false)
	private Long area;

	public RegiaoPK getId() {
		return id;
	}

	public void setId(RegiaoPK id) {
		this.id = id;
	}

	@Override
	public RegiaoPK getPrimaryKey() {
		return this.getId();
	}

	@Override
	public void setPrimaryKey(RegiaoPK primaryKey) {
		this.setId(primaryKey);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Regiao other = (Regiao) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
