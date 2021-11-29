package q2.entity;

import q2.entity.base.BaseEntity;
import q2.entity.base.BaseEntityInterface;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
public class Branch extends BaseEntity implements BaseEntityInterface<Integer> {
    @Column
    private String name;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
