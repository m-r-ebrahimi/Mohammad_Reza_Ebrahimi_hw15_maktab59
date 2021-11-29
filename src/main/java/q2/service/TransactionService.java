package q2.service;

import q2.dao.TransactionDao;
import q2.entity.Transaction;
import q2.service.core.CrudService;

public class TransactionService extends CrudService<Transaction, Integer> {
    public TransactionService() {
        setBaseDao(new TransactionDao(getEntityManager()));
    }

    public TransactionDao getBaseDao() {
        return (TransactionDao) super.getBaseDao();
    }
}
