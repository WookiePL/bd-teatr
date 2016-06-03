package theater.services;

import theater.persist.dtos.EventRealizationDTO;
import theater.persist.dtos.ReservationDTO;

import java.util.List;

public interface IEventService {

    List<EventRealizationDTO> getAllEventRealization();

    List<ReservationDTO> getAllEventReservation();

    List<ReservationDTO> getAllEventReservation(Integer id);

    ReservationDTO getReservationById(Integer id);

    EventRealizationDTO getEventRealizationById(Integer id);

    void updateReservation(ReservationDTO reservation);

}

