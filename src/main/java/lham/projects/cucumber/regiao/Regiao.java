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
}
