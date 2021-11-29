package q2.dao;

import q2.dao.core.BaseDao;
import q2.entity.Account;

import javax.persistence.EntityManager;

public class AccountDao extends BaseDao<Account, Integer> {
    public AccountDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }
}
