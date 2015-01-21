package lham.projects.cucumber.infra;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

/**
 * Base para as classes de servi�o do sistema.
 * 
 * @author Luiz Henrique A. Mello
 * 
 * @param <E>
 *            entidade que ser� gerenciado por esta classe. Esta entidade deve
 *            estender a classe {@code AbstractEntity}.
 * 
 * @param <K>
 *            tipo da chave prim�ria da entidade gerenciada por esta classe.
 * 
 * @see lham.projects.confrontosgremio.infra.AbstractModel
 */
public abstract class AbstractService<E extends AbstractEntity<K>, K> implements Serializable {

    private static final long serialVersionUID = 1L;
    private transient BaseDAO<E, K> dao;

    /**
     * Deve instanciar o <i>DAO</i> que ser� gerenciado pela classe de servi�o.
     */
    @PostConstruct
    public abstract void initDAO();

    /**
     * Pequisa uma lista de registros que atendam os crit�rios passados para a
     * pesquisa, atrav�s da classe {@link BaseDAO}.
     * 
     * @param entity
     *            entidade usada para pequisada. Os campos, n�o nulos, da
     *            entidade ser�o os crit�rios utilizados para a pequisa dos
     *            dados.
     * 
     * @return lista contendo os registros que atendam os crit�rios pesquisados;
     *         ou uma lista vazia se nenhum registro for encontrado.
     */
    public List<E> find(final E entity) {
        return dao.find(entity);
    }

    /**
     * Insere uma entidade no banco de dados atrav�s da classe {@link BaseDAO}.
     * 
     * @param entity
     *            entidade que ser� persistida.
     * 
     * @return a entidade persistida.
     */
    public E insert(final E entity) {
        return dao.insert(entity);
    }

    public long count(final E entity) {
    	return dao.count(entity);
    }
    
    /**
     * Define a classe <i>DAO</i> que ser� gerenciado pela classe de servi�o.
     * 
     * @param dao
     *            <i>DAO</i> que ser� gerenciado pela classe de servi�o.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void setDAO(final BaseDAO dao) {
        this.dao = dao;
    }
}
