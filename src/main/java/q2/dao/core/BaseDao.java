package q2.dao.core;

import q2.entity.base.BaseEntity;
import q2.entity.base.BaseEntityInterface;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseDao<T extends BaseEntity,ID extends Number> implements BaseDaoInterface<T,ID> {
    private EntityManager entityManager;

    public BaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(ID id, T newEntity) {
        entityManager.getTransaction().begin();
        entityManager.merge(newEntity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(ID id) {
        T entity = loadById(id);
        entityManager.remove(entity);
    }

    @Override
    public T loadById(ID id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<T> loadAll() {
        return entityManager.createQuery("From " +
                getEntityClass().getSimpleName()).getResultList();
    }

    @Override
    public abstract Class<T> getEntityClass() ;
}
