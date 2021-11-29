package q2.dao;

import q2.dao.core.BaseDao;
import q2.entity.Transaction;

import javax.persistence.EntityManager;

public class TransactionDao extends BaseDao<Transaction,Integer> {
    public TransactionDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Transaction> getEntityClass() {
        return Transaction.class;
    }
}
