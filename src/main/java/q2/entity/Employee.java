package q2.entity;

import q2.entity.base.BaseEntity;
import q2.entity.base.BaseEntityInterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Employee extends BaseEntity implements BaseEntityInterface<Integer> {
    @Column
    private String name;
    @ManyToOne
    private Branch branch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(branch, employee.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, branch);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", branch=" + branch +
                '}';
    }
}
