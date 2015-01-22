package lham.projects.cucumber.infra;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Classe base para as classes de entidade.
 * 
 * @author Luiz Henrique A. Mello
 * 
 * @param <K>
 *            tipo da chave primária da entidade.
 */
@MappedSuperclass
public abstract class AbstractEntity<K> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "LOG_DATA_HORA_INCLUSAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataHoraInclusao;

    @Column(name = "LOG_DATA_HORA_ALTERACAO", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataHoraUltimaAlteracao;

    @Column(name = "LOG_USUARIO_INCLUSAO", nullable = false)
    private Long usuarioInclusao;

    @Column(name = "LOG_USUARIO_ALTERACAO", nullable = true)
    private Long usuarioUltimaAlteracao;

    @Column(name = "LOG_IP_USUARIO_INCLUSAO", nullable = false, length = 15)
    private String ipUsuarioInclusao;

    @Column(name = "LOG_IP_USUARIO_ALTERACAO", nullable = true, length = 15)
    private String ipUsuarioUltimaAlteracao;

    @Transient
    private PropLista propLista = new PropLista(0, 2);

    /**
     * Retorna a chave primária da entidade.
     * 
     * @return a chave primária da entidade.
     */
    public abstract K getPrimaryKey();

    /**
     * Define a chave primária da entidade.
     * 
     * @param primaryKey
     *            chave primária.
     */
    public abstract void setPrimaryKey(final K primaryKey);

    public Calendar getDataHoraInclusao() {
        return dataHoraInclusao;
    }

    public void setDataHoraInclusao(Calendar dataHoraInclusao) {
        this.dataHoraInclusao = dataHoraInclusao;
    }

    public Calendar getDataHoraUltimaAlteracao() {
        return dataHoraUltimaAlteracao;
    }

    public void setDataHoraUltimaAlteracao(Calendar dataHoraUltimaAlteracao) {
        this.dataHoraUltimaAlteracao = dataHoraUltimaAlteracao;
    }

    public Long getUsuarioInclusao() {
        return usuarioInclusao;
    }

    public void setUsuarioInclusao(Long usuarioInclusao) {
        this.usuarioInclusao = usuarioInclusao;
    }

    public Long getUsuarioUltimaAlteracao() {
        return usuarioUltimaAlteracao;
    }

    public void setUsuarioUltimaAlteracao(Long usuarioUltimaAlteracao) {
        this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
    }

    public String getIpUsuarioInclusao() {
        return ipUsuarioInclusao;
    }

    public void setIpUsuarioInclusao(String ipUsuarioInclusao) {
        this.ipUsuarioInclusao = ipUsuarioInclusao;
    }

    public String getIpUsuarioUltimaAlteracao() {
        return ipUsuarioUltimaAlteracao;
    }

    public void setIpUsuarioUltimaAlteracao(String ipUsuarioUltimaAlteracao) {
        this.ipUsuarioUltimaAlteracao = ipUsuarioUltimaAlteracao;
    }

    public PropLista getPropLista() {
        return propLista;
    }

    public void setPropLista(PropLista propLista) {
        this.propLista = propLista;
    }
}
