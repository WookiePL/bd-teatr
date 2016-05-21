package theater.persist.daos;

import theater.persist.model.PlaceEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface IPlaceDAO extends IBaseDAO<PlaceEntity, Integer> {

    PlaceEntity getPlaceById(int id);

    List<PlaceEntity> getAllPlaces();

    void addPlace(PlaceEntity place);

    void updatePlace(PlaceEntity place);

    void deletePlace(int id);
}
