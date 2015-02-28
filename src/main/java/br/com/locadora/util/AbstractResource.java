package br.com.locadora.util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractResource<T extends AbstractModel, DTO extends AbstractDto> {
    @PersistenceContext
    protected EntityManager em;
    
    protected Class<T> entityClass;

    public AbstractResource(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract DTO create(DTO dto);

    public abstract DTO update(Long id, DTO dto);

    public void remove(T entity) {
        em.remove(em.merge(entity));
    }
    
    public void removeById(Long id) {
        em.remove(em.merge(find(id)));
    }

    public T find(Object id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
    
}
