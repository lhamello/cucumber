package lham.projects.cucumber.infra;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Classe base para as classes DAO do sistema.
 * 
 * @author Luiz Henrique A. Mello
 * 
 * @param <E>
 *            entidade que será gerenciado pelo DAO.
 * @param <K>
 *            tipo da chave primária da entidade gerenciada pelo DAO.
 */
public class BaseDAO<E extends AbstractEntity<K>, K> {

    @PersistenceContext
    private transient EntityManager entityManager;
    private final transient Class<E> entityClass;

    /**
     * Inicializa os atributos definidos na classe.
     */
    @SuppressWarnings("unchecked")
    public BaseDAO() {
        final ParameterizedType superClass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) superClass.getActualTypeArguments()[0];
    }

    /**
     * Pesquisa uma lista de registros no banco de dados a partir dos critérios
     * especificados.
     * 
     * @param entity
     *            entidade que informa os critérios da pesquisa.
     * 
     * @return uma lista de registros que atendam os critérios informados ou uma
     *         lista vazia se não for encontrado nenhum registro que atenda os
     *         critérios informados.
     */
    @SuppressWarnings("unchecked")
    public List<E> find(final E entity) {
        final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
        
        detachedCriteria.add(Example.create(entity).enableLike(MatchMode.ANYWHERE).ignoreCase());
        
        this.addOrder(entity, detachedCriteria);
        
        final Criteria criteria = detachedCriteria.getExecutableCriteria(entityManager.unwrap(Session.class));
        criteria.setFirstResult(entity.getPropLista().getInicio());
		criteria.setMaxResults(entity.getPropLista().getTamanho());
		
        return criteria.list();
    }

    /**
     * Busca uma entidade pelo valor exato de sua chave primária.
     * 
     * @param primaryKey
     *            chave primária da entidade.
     * 
     * @return a entidade encontrada.
     */
    @SuppressWarnings("unchecked")
    public E findyByPK(final K primaryKey) {
        final String namedQuery = this.createNamedQuery("findById");

        final Query query = entityManager.createNamedQuery(namedQuery);
        query.setParameter("pk", primaryKey);

        return (E) query.getSingleResult();
    }

    /**
     * Insere uma entidade no banco de dados.
     * 
     * @param entity
     *            entidade que será persistida.
     * 
     * @return a entidade persistida.
     */
    public E insert(final E entity) {
        entityManager.persist(entity);
        entityManager.flush();

        return entity;
    }

    /**
     * Define o {@code entityManager} da aplicação.
     * 
     * @param entityManager
     *            {@code entityManager} da aplicação.
     */
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public long count(final E entity) {
    	final DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
        detachedCriteria.add(Example.create(entity).enableLike(MatchMode.ANYWHERE).ignoreCase());
        
    	final Criteria criteria = detachedCriteria.getExecutableCriteria(entityManager.unwrap(Session.class));
        criteria.setProjection(Projections.count(entityManager.unwrap(Session.class).getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName()));
        
        Long result = (Long) criteria.uniqueResult();
        return result.longValue();
    }
    
    /**
     * Monta uma <i>named query</i> e a retorna.
     * 
     * @param querySuffix
     *            sufixo da <i>named query</i>.
     * 
     * @return a <i>named query</i> no formato: [nome da entidade].[sufixo da
     *         query].
     */
    private String createNamedQuery(final String querySuffix) {
        final StringBuilder namedQuery = new StringBuilder();
        namedQuery.append(entityClass.getSimpleName()).append(".").append(querySuffix);

        return namedQuery.toString();
    }
    
    
    public void addOrder(E entity, DetachedCriteria detachedCriteria) {
        boolean incluiuOrdem = false;
    	final List<Ordem> ordenacao = entity.getPropLista().getOrdem();
    	
        for (Ordem ordem : ordenacao) {
        	
        	if(ordem.getPropriedade() != null){
        	    incluiuOrdem = true;
        	    
        		if (ordem.isAsc()) {
        			detachedCriteria.addOrder(Order.asc(ordem.getPropriedade()).ignoreCase());
        		} else {
        			detachedCriteria.addOrder(Order.desc(ordem.getPropriedade()).ignoreCase());
        		}
        	}
		}
        
        if (incluiuOrdem) {
        	detachedCriteria.addOrder(Order.asc(entityManager.unwrap(Session.class).getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName())); 
        }
    }

    public void deleteAll() {
        entityManager.createQuery("DELETE FROM " +entityClass.getSimpleName()).executeUpdate();
    }
}
