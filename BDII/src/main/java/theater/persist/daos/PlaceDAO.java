package theater.persist.daos;

import org.springframework.stereotype.Repository;
import theater.persist.model.PlaceEntity;

import java.util.List;

@Repository
public class PlaceDAO extends BaseDAO<PlaceEntity, Integer> implements IPlaceDAO {
    @Override
    public PlaceEntity getPlaceById(int id) {
        PlaceEntity place = super.readById(id);
        if (place != null) {
            return place;
        }
        return null;
    }

    @Override
    public List<PlaceEntity> getAllPlaces() {
        return super.getAll();
    }

    @Override
    public void addPlace(PlaceEntity place) {
        super.create(place);
    }

    @Override
    public void updatePlace(PlaceEntity place) {
        super.update(place);
    }

    @Override
    public void deletePlace(int id) {
        PlaceEntity place = super.readById(id);
        if (place != null) {
            super.delete(place);
        }

    }
}
