package theater.persist.daos;


import theater.persist.model.RoomEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomDAO extends BaseDAO<RoomEntity, Integer> implements IRoomDAO {

    @Override
    public RoomEntity getRoomById(int id) {
        RoomEntity room = super.readById(id);
        if (room != null) {
            return room;
        }
        return null;
    }

    @Override
    public List<RoomEntity> getAllRooms() {
        return super.getAll();
    }

    @Override
    public void addRoom(RoomEntity room) {
        super.create(room);
    }

    @Override
    public void updateRoom(RoomEntity room) {
        super.update(room);
    }

    @Override
    public void deleteRoom(int id) {
        RoomEntity room = super.readById(id);
        if (room != null) {
            super.delete(room);
        }
    }

}
