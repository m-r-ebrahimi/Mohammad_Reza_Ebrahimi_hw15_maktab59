package q2.entity;

import q2.entity.base.BaseEntity;
import q2.entity.base.BaseEntityInterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Card extends BaseEntity implements BaseEntityInterface<Integer> {
    @Column
    private String cardNumber;
    @Column
    private Integer cvv2;
    @Column
    private String expiration;
    @Column
    private String firstPassword;
    @Column
    private String secondPassword;
    @OneToOne
    private Account account;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCvv2() {
        return cvv2;
    }

    public void setCvv2(Integer cvv2) {
        this.cvv2 = cvv2;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getFirstPassword() {
        return firstPassword;
    }

    public void setFirstPassword(String firstPassword) {
        this.firstPassword = firstPassword;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardNumber, card.cardNumber) && Objects.equals(cvv2, card.cvv2) && Objects.equals(expiration, card.expiration) && Objects.equals(firstPassword, card.firstPassword) && Objects.equals(secondPassword, card.secondPassword) && Objects.equals(account, card.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cvv2, expiration, firstPassword, secondPassword, account);
    }
}
