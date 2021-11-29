package q2.service;

import q2.dao.EmployeeDao;
import q2.entity.Employee;
import q2.service.core.CrudService;

public class EmployeeService extends CrudService<Employee, Integer> {
    public EmployeeService() {
        setBaseDao(new EmployeeDao(getEntityManager()));
    }

    public EmployeeDao getBaseDao() {
        return (EmployeeDao) super.getBaseDao();
    }
}
