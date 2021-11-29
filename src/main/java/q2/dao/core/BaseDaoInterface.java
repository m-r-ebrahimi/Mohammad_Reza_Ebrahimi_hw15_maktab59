package q2.dao.core;

import q2.entity.base.BaseEntity;
import q2.entity.base.BaseEntityInterface;

import java.util.List;

public interface BaseDaoInterface<T extends BaseEntity, ID extends Number>{
    void save(T entity);

    void update(ID id, T newEntity);

    void delete(ID id);

    T loadById(ID id);

    List<T> loadAll();

    Class<T> getEntityClass();
}
