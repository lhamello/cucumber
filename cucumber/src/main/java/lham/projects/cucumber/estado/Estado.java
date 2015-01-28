package lham.projects.cucumber.estado;

import javax.persistence.CascadeType;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lham.projects.cucumber.infra.AbstractEntity;
import lham.projects.cucumber.regiao.Regiao;

@Entity
@Table(name = "ESTADO", uniqueConstraints = @UniqueConstraint(name = "ESTADO_UC", columnNames = {"SIGLA", "ID_REGIAO"}))
@NamedQueries(value = { @NamedQuery(name = "Estado.findByPk", query = "SELECT e FROM Estado e WHERE e.id = :pk") })
public class Estado extends AbstractEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "Estado_SEQ", sequenceName = "ID_ESTADO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Estado_SEQ")
    @Column(name = "ID_ESTADO")
    private Long id;

    @Column(name = "SIGLA", nullable = false)
    @NotNull
    private String sigla;
    
    @JoinColumn(name = "ID_REGIAO")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Regiao regiao;
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
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
