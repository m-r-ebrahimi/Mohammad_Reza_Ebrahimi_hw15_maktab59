package q2.entity;

import q2.entity.base.BaseEntity;
import q2.entity.base.BaseEntityInterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Card extends BaseEntity implements BaseEntityInterface<Integer> {
    @Column
    private String number;

    @Column
    private String cvv;

    @Column(name = "card_pin")
    private String pin;

    @Column(name = "card_expDate")
    private String expDate;

    @OneToOne
    private Account account;

}
