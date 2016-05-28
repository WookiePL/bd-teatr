package theater.persist.daos;

import org.springframework.stereotype.Repository;
import theater.persist.model.PriceEntity;

import java.util.List;

@Repository
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
