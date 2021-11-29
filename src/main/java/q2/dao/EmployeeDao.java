package q2.dao;

import q2.dao.core.BaseDao;
import q2.entity.Employee;

import javax.persistence.EntityManager;

public class EmployeeDao extends BaseDao<Employee,Integer> {
    public EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
