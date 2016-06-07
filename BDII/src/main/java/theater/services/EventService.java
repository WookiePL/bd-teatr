package theater.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import theater.persist.daos.*;
import theater.persist.dtos.EventRealizationDTO;
import theater.persist.dtos.ReservationDTO;
import theater.persist.model.BuildingEntity;
import theater.persist.model.EventRealizationEntity;
import theater.persist.model.ReservationEntity;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EventService implements IEventService {

    @Autowired
    private EventRealizationDAO eventRealizationDAO;

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<EventRealizationDTO> getAllEventRealization() {
        List<EventRealizationDTO> realizationDTOs = new ArrayList<>();
        for(EventRealizationEntity list: eventRealizationDAO.getAll()){
            realizationDTOs.add(convertToDto(list));
        }
        return realizationDTOs;
    }

    @Override
    public List<ReservationDTO> getAllEventReservationByRealization(int id) {
        List<ReservationDTO> reservationDTOs = new ArrayList<>();
        for(ReservationEntity list: reservationDAO.getAllReservationsByRealization(id)){
            reservationDTOs.add(convertToDto(list));
        }
        return reservationDTOs;
    }

    @Override
    public List<ReservationDTO> getAllEventReservation() {
        List<ReservationDTO> reservationDTOs = new ArrayList<>();
        for(ReservationEntity list: reservationDAO.getAll()){
            reservationDTOs.add(convertToDto(list));
        }
        return reservationDTOs;
    }

    @Override
    public List<ReservationDTO> getAllEventReservation(Integer id) {
        List<ReservationDTO> reservationDTOs = new ArrayList<>();
        for(ReservationEntity list: reservationDAO.getAllReservations(id)){
            reservationDTOs.add(convertToDto(list));
        }
        return reservationDTOs;
    }

    @Override
    public ReservationDTO getReservationById(Integer id) {
        return convertToDto(reservationDAO.getReservationById(id));
    }

    @Override
    public EventRealizationDTO getEventRealizationById(Integer id) {
        return convertToDto(eventRealizationDAO.getEventRealizationById(id));
    }

    @Override
    public void updateReservation(ReservationDTO reservation) {
        reservationDAO.updateReservation(convertToEntity(reservation));
    }

    @Override
    public void deleteReservation(Integer id) {
        reservationDAO.deleteReservation(id);
    }



    private ReservationDTO convertToDto(ReservationEntity reservationEntity) {
        ReservationDTO postDto = modelMapper.map(reservationEntity, ReservationDTO.class);
        return postDto;
    }

    private ReservationEntity convertToEntity(ReservationDTO reservationDTO) throws ParseException {
        ReservationEntity reservation = modelMapper.map(reservationDTO, ReservationEntity.class);
        return reservation;
    }

    private EventRealizationDTO convertToDto(EventRealizationEntity eventRealizationEntity) {
        EventRealizationDTO postDto = modelMapper.map(eventRealizationEntity, EventRealizationDTO.class);
        return postDto;
    }
}
