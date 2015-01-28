package lham.projects.cucumber.infra;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lham.projects.cucumber.regiao.Regiao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
    protected transient EntityManager entityManager;
    private final transient Class<E> entityClass;

    /**
     * Inicializa os atributos definidos na classe.
     */
    @SuppressWarnings("unchecked")
    public BaseDAO() {
        final ParameterizedType superClass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) superClass.getActualTypeArguments()[0];
    }    
    
    public DetachedCriteria adicionarRestricoes(DetachedCriteria detachedCriteria, final E entity) {
    	detachedCriteria.add(Example.create(entity).enableLike(MatchMode.ANYWHERE).ignoreCase());
    	return detachedCriteria;
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
    public List<E> listar(final E entity) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
        
        detachedCriteria = this.adicionarRestricoes(detachedCriteria, entity);
        
        this.adicionarOrdem(entity, detachedCriteria);
        
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
    public E consultarPorNamedQuery(final K primaryKey) {
        final String namedQuery = this.criarNamedQuery("findById");

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
    public E incluir(final E entity) {
        entityManager.persist(entity);
        entityManager.flush();

        return entity;
    }

    /**
     * Altera uma entidade no banco de dados.
     * 
     * @param entity
     *            entidade que será alterada.
     * 
     * @return a entidade alterada.
     */
    public E alterar(final E entity) {
        entityManager.merge(entity);
        entityManager.flush();

        return entity;
    }
    


	public void excluir(final E entity) {
		entityManager.remove(entity);
        entityManager.flush();
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
    
    public long contar(final E entity) {
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
    private String criarNamedQuery(final String querySuffix) {
        final StringBuilder namedQuery = new StringBuilder();
        namedQuery.append(entityClass.getSimpleName()).append(".").append(querySuffix);

        return namedQuery.toString();
    }
    
    
    public void adicionarOrdem(E entity, DetachedCriteria detachedCriteria) {
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
    
    public DetachedCriteria criarCriterioDesatachado() {
    	return DetachedCriteria.forClass(entityClass);
    }
    
    public Criteria criarCriterio() {
    	return this.criarCriterioDesatachado().getExecutableCriteria(entityManager.unwrap(Session.class));
    }
    
    public E consultarChave(K pk) {
    	final Criteria crit = this.criarCriterio();
    	crit.add(Restrictions.idEq(pk));
    	return (E) crit.uniqueResult();
    }
}
