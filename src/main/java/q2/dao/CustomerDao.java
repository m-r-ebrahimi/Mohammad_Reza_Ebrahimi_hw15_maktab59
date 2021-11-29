package q2.dao;

import q2.dao.core.BaseDao;
import q2.entity.Customer;

import javax.persistence.EntityManager;

public class CustomerDao extends BaseDao<Customer,Integer> {
    public CustomerDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
