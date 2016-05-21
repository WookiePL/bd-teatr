package theater.persist.daos;

import theater.persist.model.PlaceEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public class PlaceDAO extends BaseDAO<PlaceEntity, Integer> implements IPlaceDAO {
    @Override
    public PlaceEntity getPlaceById(int id) {
        return null;
    }

    @Override
    public List<PlaceEntity> getAllPlaces() {
        return null;
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
