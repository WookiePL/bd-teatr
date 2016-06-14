package theater.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import theater.helper.SectorInfo;
import theater.persist.daos.*;
import theater.persist.dtos.*;
import theater.persist.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class EventService implements IEventService {

    @Autowired
    private EventRealizationDAO eventRealizationDAO;

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private SectorDAO sectorDAO;

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
    public List<SectorDTO> getAllSectorsByRealizationId(int id) {
        return null;
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
    public List<SectorInfo> getRoomInfo(Integer realizationId) {
        EventRealizationDTO event = convertToDto(eventRealizationDAO.getEventRealizationById(realizationId));
        RoomEntity room = event.getRoom();
        List<SectorEntity> sectors = room.getSectors();
        List<SectorInfo> roomInfo = new ArrayList<>();
        for (int i = 0; i < sectors.size(); i++) {
            SectorInfo sectorInfo = new SectorInfo();
            sectorInfo.name = sectors.get(i).getNumber();
            int numberOfPlaces = sectors.get(i).getPlaces().size();
            sectorInfo.rowsNumber = 2;
            sectorInfo.columnsNumber = numberOfPlaces/2;
            sectorInfo.occupiedSeats = new ArrayList<>();
            List<ReservationEntity> reservations = event.getReservations();
            for (int j = 0; j < reservations.size(); j++) {
                List<PlaceEntity> places = new ArrayList<>(reservations.get(j).getPlaces());
                for (int k = 0; k < places.size(); k++) {
                    sectorInfo.occupiedSeats.add(places.get(k).getNumber());
                }
            }
            roomInfo.add(sectorInfo);
        }
        return roomInfo;
    }

    @Override
    public List<PlaceDTO> convertSelectedSeatsStringArrayToPlaceList(String[] seats) {
        List<PlaceDTO> places = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            String[] splitted = seats[i].split(",");
            if(splitted.length > 1) {
                Integer sectorNumber = Integer.parseInt(splitted[0]);
                SectorEntity sector = sectorDAO.findByNumber(sectorNumber);
                List<PlaceEntity> allSectorPlaces = sector.getPlaces();
                for (int j = 0; j < allSectorPlaces.size(); j++) {
                    for (int k = 1; k < splitted.length; k++) {
                        Integer num = allSectorPlaces.get(j).getNumber();
                        if(allSectorPlaces.get(j).getNumber() == Integer.parseInt(splitted[k])) {
                            places.add(convertToDto(allSectorPlaces.get(j)));
                        }
                    }
                }
            }
        }
        return places;
    }

    @Override
    public void updateReservation(ReservationDTO reservation) {
        reservationDAO.updateReservation(convertToEntity(reservation));
    }

    @Override
    public void deleteReservation(Integer id) {
        reservationDAO.deleteReservation(id);
    }

    private PlaceDTO convertToDto(PlaceEntity placeEntity) {
        PlaceDTO postDto = modelMapper.map(placeEntity, PlaceDTO.class);
        return postDto;
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
