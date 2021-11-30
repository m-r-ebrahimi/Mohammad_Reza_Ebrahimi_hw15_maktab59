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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Transaction> getTransactionOrigins() {
        return transactionOrigins;
    }

    public void setTransactionOrigins(List<Transaction> transactionOrigins) {
        this.transactionOrigins = transactionOrigins;
    }

    public List<Transaction> getTransactionDestinations() {
        return transactionDestinations;
    }

    public void setTransactionDestinations(List<Transaction> transactionDestinations) {
        this.transactionDestinations = transactionDestinations;
    }

    @Override
    public String toString() {
        return "Account{" +
                "customer=" + customer +
                ", branch=" + branch +
                ", balance=" + balance +
                ", card=" + card +
                '}';
    }
}
