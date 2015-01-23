package lham.projects.cucumber.cidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lham.projects.cucumber.infra.AbstractEntity;

@Entity
@Table(name = "CIDADE")
@NamedQueries(value = { @NamedQuery(name = "Cidade.findByPk", query = "SELECT c FROM Cidade c WHERE c.id = :pk") })
public class Cidade extends AbstractEntity<CidadePK> {

    private static final long serialVersionUID = 1L;

    @Id
    private CidadePK id;

    @Column(name = "PIB", nullable = false)
    private Long pib;

    @Column(name = "CLASSIFICAO", nullable = false)
    @Enumerated(EnumType.STRING)
    private ClassificaoCidade classificacao;

    @Column(name = "POPULACAO", nullable = true)
    private Long populacao;

    public CidadePK getId() {
        return id;
    }

    public void setId(CidadePK id) {
        this.id = id;
    }

    public Long getPib() {
        return pib;
    }

    public void setPib(Long pib) {
        this.pib = pib;
    }

    public ClassificaoCidade getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificaoCidade classificacao) {
        this.classificacao = classificacao;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    @Override
    public CidadePK getPrimaryKey() {
        return this.getId();
    }

    @Override
    public void setPrimaryKey(CidadePK primaryKey) {
        this.setId(primaryKey);
    }
}
