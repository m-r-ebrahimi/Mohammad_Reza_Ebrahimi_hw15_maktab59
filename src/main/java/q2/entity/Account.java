package q2.entity;

import q2.entity.base.BaseEntity;
import q2.entity.base.BaseEntityInterface;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Account extends BaseEntity implements BaseEntityInterface<Integer> {
    @Column
    private Integer balance;

    @Column
    private boolean isLocked = false;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private Customer customer;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private CreditCard creditCard;


    @OneToMany(mappedBy = "origin", cascade = CascadeType.ALL)
    private List<Transaction> origin;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private List<Transaction> dest;
}
