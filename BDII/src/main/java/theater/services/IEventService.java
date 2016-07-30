package theater.services;

import theater.helper.SectorInfo;
import theater.persist.dtos.*;
import theater.persist.model.EventRealizationEntity;
import theater.persist.model.PlaceEntity;
import theater.persist.model.PriceListEntity;

import java.util.Date;
import java.util.List;

public interface IEventService {


    List<PlaceDTO> getAllPlaces();

    List<EventRealizationDTO> getAllEventRealization();

    List<EventDTO> getAllEvents();

    List<EventTypeDTO> getAllEventTypes();

    public EventDTO getEventById(Integer id);

    public void addEvent(String eventName, Integer eventTypeId, String eventDescription);

    public void deleteEvent(Integer id);

    public void updateEvent(Integer eventId, String eventName, Integer eventType, String eventDescription);

    List<ReservationDTO> getAllEventReservation();

    List<SectorDTO> getAllSectorsByRealizationId(int id);

    List<ReservationDTO> getAllEventReservationByRealization(int id);

    public List<BuildingDTO> getAllBuildings();

    public List<RoomDTO> getAllRooms();

    public void addRealization(Integer eventId, Integer roomId, String realizationDate, Integer realizationTime);

    public void updateRealization(Integer realizationId, Integer eventId, Integer roomId, Date realizationDate, Integer realizationHour);

    public void deleteEventRealization(Integer id);

    List<ReservationDTO> getAllEventReservation(Integer id);

    ReservationDTO getReservationById(Integer id);

    EventRealizationDTO getEventRealizationById(Integer id);

    List<SectorInfo> getRoomInfo(Integer realizationId);

    List<PlaceDTO> convertSelectedSeatsStringArrayToPlaceList(String[] seats);
    List<PlaceEntity> convertSelectedSeatsStringArrayToPlaceEntityList(String[] seats);

    List<PlaceDTO> getPlaceListFromIds(String[] placeIds);

    void updateReservation(Integer reservationId, ReservationDTO reservation);


    void deleteReservation(Integer id);

    List<PriceListDTO> getAllPriceList();

    PriceListDTO getPriceListById(Integer id);

    void deletePriceList(Integer id);

    void updatePriceList(Integer priceListID, PriceListDTO priceList);

    void updatePriceList(Integer priceListId, String priceListFrom, String priceListTo, String priceListName, Integer eventId);

    void addPriceList(String priceListFrom, String priceListTo, String priceListName, Integer eventId);

    List<PlaceEntity> convertToEntity(List<PlaceDTO> placeDTOList);

    EventRealizationEntity convertToEntity(EventRealizationDTO eventRealizationDTO);

    void addReservation(ReservationDTO reservation, EventRealizationDTO eventRealization, List<PlaceDTO> selectedPlaces);

    void addTicket(EventRealizationDTO eventRealization, List<PlaceDTO> selectedPlaces);

    PriceListEntity getPriceListForEvent(Integer eventId, Date date);
}

