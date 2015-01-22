package lham.projects.cucumber.infra;

import java.io.Serializable;

/**
 * Classe base para os <i>managed</i> beans do sistema.
 * 
 * @author Luiz Henrique A. Mello
 * 
 * @param <E>
 *            entidade gerenciada pelo managed bean.
 * 
 * @param <K>
 *            tipo da chave primária da entidade gerenciada.
 */
public class BaseBean<E extends AbstractEntity<K>, K> implements Serializable {

    private static final long serialVersionUID = 1L;

}
