package q2.service;

import q2.dao.BranchDao;
import q2.entity.Branch;
import q2.service.core.CrudService;

public class BranchService extends CrudService<Branch, Integer> {
    public BranchService() {
        setBaseDao(new BranchDao(getEntityManager()));
    }

    public BranchDao getBaseDao() {
        return (BranchDao) super.getBaseDao();
    }
}
