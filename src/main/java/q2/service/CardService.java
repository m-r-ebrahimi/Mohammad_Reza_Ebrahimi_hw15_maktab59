package q2.service;

import q2.dao.CardDao;
import q2.entity.Card;
import q2.service.core.CrudService;

public class CardService extends CrudService<Card, Integer> {
    public CardService() {
        setBaseDao(new CardDao(getEntityManager()));
    }

    public CardDao getBaseDao() {
        return (CardDao) super.getBaseDao();
    }
}
