package lham.projects.cucumber.infra;

import java.io.Serializable;

/**
 * Classe base para as classes de entidade.
 * 
 * @author Luiz Henrique A. Mello
 * 
 * @param <K>
 *            tipo da chave prim�ria da entidade.
 */
public abstract class AbstractEntity<K> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Retorna a chave prim�ria da entidade.
     * 
     * @return a chave prim�ria da entidade.
     */
    public abstract K getPrimaryKey();

    /**
     * Define a chave prim�ria da entidade.
     * 
     * @param primaryKey
     *            chave prim�ria.
     */
    public abstract void setPrimaryKey(final K primaryKey);
}
