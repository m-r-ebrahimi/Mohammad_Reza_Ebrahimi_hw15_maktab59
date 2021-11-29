package q2.dao;

import q2.dao.core.BaseDao;
import q2.entity.Branch;

import javax.persistence.EntityManager;

public class BranchDao extends BaseDao<Branch,Integer> {
    public BranchDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Branch> getEntityClass() {
        return Branch.class;
    }
}
