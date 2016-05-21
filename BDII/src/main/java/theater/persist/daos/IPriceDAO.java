package theater.persist.daos;

import theater.persist.model.PriceEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface IPriceDAO extends IBaseDAO<PriceEntity, Integer> {

    PriceEntity getPriceById(int id);

    List<PriceEntity> getAllPrices();

    void addPrice(PriceEntity price);

    void updatePrice(PriceEntity price);

    void deletePrice(int id);
}
