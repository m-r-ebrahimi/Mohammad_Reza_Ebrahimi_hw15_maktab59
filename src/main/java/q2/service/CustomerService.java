package q2.service;

import q2.dao.CustomerDao;
import q2.entity.Customer;
import q2.service.core.CrudService;

public class CustomerService extends CrudService<Customer, Integer> {
    public CustomerService() {
        setBaseDao(new CustomerDao(getEntityManager()));
    }

    public CustomerDao getBaseDao() {
        return (CustomerDao) super.getBaseDao();
    }
}
