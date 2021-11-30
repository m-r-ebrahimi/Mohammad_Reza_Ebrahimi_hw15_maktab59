package q2.entity;

import q2.entity.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Branch extends BaseEntity {
    @Column
    private Integer code;
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Account> accounts;
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return code.equals(branch.code) && Objects.equals(accounts, branch.accounts) && Objects.equals(employees, branch.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, accounts, employees);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "code=" + code +
                '}';
    }
}
