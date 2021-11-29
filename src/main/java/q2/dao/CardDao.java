package q2.dao;

import q2.dao.core.BaseDao;
import q2.entity.Branch;
import q2.entity.Card;

import javax.persistence.EntityManager;

public class CardDao extends BaseDao<Card,Integer> {
    public CardDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Card> getEntityClass() {
        return Card.class;
    }
}
