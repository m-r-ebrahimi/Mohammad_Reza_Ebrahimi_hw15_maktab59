package q2.entity;

import q2.entity.base.BaseEntity;
import q2.entity.base.BaseEntityInterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Transaction extends BaseEntity implements BaseEntityInterface<Integer> {
    @Column
    private LocalTime time;
    @Column
    Integer amount;
    @ManyToOne
    private Account originAccount;
    @ManyToOne
    private Account destinationAccount;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Account getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(Account originAccount) {
        this.originAccount = originAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(time, that.time) && Objects.equals(amount, that.amount) && Objects.equals(originAccount, that.originAccount) && Objects.equals(destinationAccount, that.destinationAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, amount, originAccount, destinationAccount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "time=" + time +
                ", amount=" + amount +
                ", originAccount=" + originAccount +
                ", destinationAccount=" + destinationAccount +
                '}';
    }
}
