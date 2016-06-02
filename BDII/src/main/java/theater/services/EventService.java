package theater.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import theater.persist.daos.BuildingDAO;
import theater.persist.daos.RoomDAO;
import theater.persist.daos.UserDAO;
import theater.persist.model.BuildingEntity;

@Service
@Transactional
public class EventService implements IEventService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoomDAO roomDAO;

    @Override
    public void addBuilding(BuildingEntity buildingEntity){

    }

}
