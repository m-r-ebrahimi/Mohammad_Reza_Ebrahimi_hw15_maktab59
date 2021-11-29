package q2.service;

import q2.dao.AccountDao;
import q2.entity.Account;
import q2.service.core.CrudService;

public class AccountService extends CrudService<Account, Integer> {
    public AccountService() {
        setBaseDao(new AccountDao(getEntityManager()));
    }

    public AccountDao getBaseDao() {
        return (AccountDao) super.getBaseDao();
    }
}
