package q2.entity;

import q2.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account extends BaseEntity {
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Branch branch;
    @Column
    private Integer balance;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Card card;
    @OneToMany(mappedBy = "originAccount", cascade = CascadeType.ALL)
    private List<Transaction> transactionOrigins;
    @OneToMany(mappedBy = "destinationAccount", cascade = CascadeType.ALL)
    private List<Transaction> transactionDestinations;
}
