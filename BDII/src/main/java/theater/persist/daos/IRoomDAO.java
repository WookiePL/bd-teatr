package theater.persist.daos;


import theater.persist.model.RoomEntity;

import java.util.List;

public interface IRoomDAO extends IBaseDAO<RoomEntity, Integer>{

    RoomEntity getRoomById(int id);

    List<RoomEntity> getAllRooms();

    void addRoom(RoomEntity building);

    void updateRoom(RoomEntity building);

    void deleteRoom(int id);
}
