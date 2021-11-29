package q2.service.core;

import q2.dao.core.BaseDao;
import q2.entity.base.BaseEntity;
import q2.exception.ModificationDataException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CrudService<T extends BaseEntity, ID extends Number> {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("jpa-maktab");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    private BaseDao<T, ID> baseDao;

    public void setBaseDao(BaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    public BaseDao<T, ID> getBaseDao() {
        return baseDao;
    }

    public void saveOrUpdate(T entity) {
        if (checkEntity(entity)) {
            baseDao.save(entity);
        } else {
            baseDao.update((ID) entity.getId(), entity);
        }
    }

    public void delete(ID id) {
        if (id == null) {
            throw new ModificationDataException("This entity NOT exist!");
        } else {
            baseDao.delete(id);
        }
    }

    public T loadById(ID id) {
        if (id == null) {
            throw new ModificationDataException("This entity NOT exist!");
        } else {
            return baseDao.loadById(id);
        }
    }

    public List<T> loadAll() {
        return baseDao.loadAll();
    }

    private boolean checkEntity(T entity) {
        if (entity == null) {throw new ModificationDataException("This entity is not live.");}
        if (entity.getId() == null) {throw new ModificationDataException("This entity is not live.");}
        T foundEntity = baseDao.loadById((ID) entity.getId());
        return foundEntity == null;
    }
}
