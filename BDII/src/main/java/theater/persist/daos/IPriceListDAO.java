package theater.persist.daos;

import theater.persist.model.PriceListEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface IPriceListDAO extends IBaseDAO<PriceListEntity, Integer> {
    PriceListEntity getPriceListById(int id);

    List<PriceListEntity> getAllPriceLists();

    void addPriceList(PriceListEntity priceList);

    void updatePriceList(PriceListEntity priceList);

    void deletePriceList(int id);
}
