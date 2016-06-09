package theater.services;

import theater.persist.dtos.EventRealizationDTO;
import theater.persist.dtos.ReservationDTO;
import theater.persist.dtos.SectorDTO;

import java.util.List;

public interface IEventService {

    List<EventRealizationDTO> getAllEventRealization();

    List<ReservationDTO> getAllEventReservation();

    List<SectorDTO> getAllSectorsByRealizationId(int id);

    List<ReservationDTO> getAllEventReservationByRealization(int id);

    List<ReservationDTO> getAllEventReservation(Integer id);

    ReservationDTO getReservationById(Integer id);

    EventRealizationDTO getEventRealizationById(Integer id);

    void updateReservation(ReservationDTO reservation);

    void deleteReservation(Integer id);

}

