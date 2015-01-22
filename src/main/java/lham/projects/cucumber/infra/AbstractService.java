package lham.projects.cucumber.infra;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.TransactionAttribute;

/**
 * Base para as classes de serviço do sistema.
 * 
 * @author Luiz Henrique A. Mello
 * 
 * @param <E>
 *            entidade que será gerenciado por esta classe. Esta entidade deve
 *            estender a classe {@code AbstractEntity}.
 * 
 * @param <K>
 *            tipo da chave primária da entidade gerenciada por esta classe.
 * 
 * @see lham.projects.confrontosgremio.infra.AbstractModel
 */
public abstract class AbstractService<E extends AbstractEntity<K>, K> implements Serializable {

    private static final long serialVersionUID = 1L;
    private transient BaseDAO<E, K> dao;

    /**
     * Deve instanciar o <i>DAO</i> que será gerenciado pela classe de serviço.
     */
    @PostConstruct
    public abstract void initDAO();

    /**
     * Pequisa uma lista de registros que atendam os critérios passados para a
     * pesquisa, através da classe {@link BaseDAO}.
     * 
     * @param entity
     *            entidade usada para pequisada. Os campos, não nulos, da
     *            entidade serão os critérios utilizados para a pequisa dos
     *            dados.
     * 
     * @return lista contendo os registros que atendam os critérios pesquisados;
     *         ou uma lista vazia se nenhum registro for encontrado.
     */
    public List<E> find(final E entity) {
        return dao.find(entity);
    }

    /**
     * Insere uma entidade no banco de dados através da classe {@link BaseDAO}.
     * 
     * @param entity
     *            entidade que será persistida.
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
     * Define a classe <i>DAO</i> que será gerenciado pela classe de serviço.
     * 
     * @param dao
     *            <i>DAO</i> que será gerenciado pela classe de serviço.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void setDAO(final BaseDAO dao) {
        this.dao = dao;
    }


    @TransactionAttribute
    public void deleteAll(){
        dao.deleteAll();
    }
}
