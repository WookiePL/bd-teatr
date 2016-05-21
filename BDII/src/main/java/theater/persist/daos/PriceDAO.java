package theater.persist.daos;

import theater.persist.model.PriceEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public class PriceDAO extends BaseDAO<PriceEntity, Integer> implements IPriceDAO {
    @Override
    public PriceEntity getPriceById(int id) {
        PriceEntity price = super.readById(id);
        if (price != null) {
            return price;
        }
        return null;
    }

    @Override
    public List<PriceEntity> getAllPrices() {
        return super.getAll();
    }

    @Override
    public void addPrice(PriceEntity price) {
        super.create(price);
    }

    @Override
    public void updatePrice(PriceEntity price) {
        super.update(price);
    }

    @Override
    public void deletePrice(int id) {
        PriceEntity price = super.readById(id);
        if (price != null) {
            super.delete(price);
        }
    }
}
