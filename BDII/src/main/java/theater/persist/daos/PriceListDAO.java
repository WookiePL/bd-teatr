package theater.persist.daos;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import theater.persist.model.PriceListEntity;

import java.util.Date;
import java.util.List;

@Repository
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

    @SuppressWarnings("unchecked")
    public PriceListEntity findByEventIdAndDate(Integer eventId, Date date) {
        List priceListEntityList =  currentSession().createCriteria(PriceListEntity.class)
                                                    .add(Restrictions.eq("eventId", eventId)).list();
//                                                    .add(Restrictions.lt("from", date))
//                                                    .add(Restrictions.gt("to", date)).uniqueResult();
        for(int i = 0; i < priceListEntityList.size(); i++) {
            PriceListEntity element = (PriceListEntity) priceListEntityList.get(i);
            if(date.after(element.getFrom()) && date.before(element.getTo())) {
                return element;
            }
        }
        return null;
    }
}
