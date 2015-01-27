package lham.projects.cucumber.regiao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lham.projects.cucumber.infra.AbstractEntity;
import lham.projects.cucumber.pais.Pais;

@Entity
@Table(name = "REGIAO")
@NamedQueries(value = { @NamedQuery(name = "Regiao.findByPk", query = "SELECT r FROM Regiao r WHERE r.id = :pk") })
public class Regiao extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "Regiao_SEQ", sequenceName = "ID_REGIAO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Regiao_SEQ")
	@Column(name = "ID_REGIAO")
	private Long id;
	
	@Column(name="NOME", nullable=false)	
	private String nomeRegiao;

	@JoinColumn(name = "PAIS", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Pais pais;
	
	@Column(name="AREA", nullable=false)
	private Long area;
	
	

	public Regiao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Regiao(String nomeRegiao, Pais pais) {
		super();
		this.nomeRegiao = nomeRegiao;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
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
	public Long getPrimaryKey() {
		return this.getId();
	}

	@Override
	public void setPrimaryKey(Long primaryKey) {
		this.setId(primaryKey);
	}
}
