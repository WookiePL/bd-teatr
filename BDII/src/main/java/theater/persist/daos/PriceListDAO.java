package theater.persist.daos;

import theater.persist.model.PriceListEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public class PriceListDAO extends BaseDAO<PriceListEntity, Integer> implements IPriceListDAO{
    @Override
    public PriceListEntity getPriceListById(int id) {
        PriceListEntity priceList = super.readById(id);
        if (priceList != null) {
            return priceList;
        }
        return null;
    }

    @Override
    public List<PriceListEntity> getAllPriceLists() {
        return super.getAll();
    }

    @Override
    public void addPriceList(PriceListEntity priceList) {
        super.create(priceList);
    }

    @Override
    public void updatePriceList(PriceListEntity priceList) {
        super.update(priceList);
    }

    @Override
    public void deletePriceList(int id) {
        PriceListEntity priceList = super.readById(id);
        if (priceList != null) {
            super.delete(priceList);
        }
    }
}
