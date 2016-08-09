package theater.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import theater.helper.DateConverter;
import theater.helper.SectorInfo;
import theater.persist.daos.*;
import theater.persist.dtos.*;
import theater.persist.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@Transactional
public class EventService implements IEventService {

    @Autowired
    private EventRealizationDAO eventRealizationDAO;

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private BuildingDAO buildingDAO;

    @Autowired
    private RoomDAO roomDAO;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private EventTypeDAO eventTypeDAO;

    @Autowired
    private SectorDAO sectorDAO;

    @Autowired
    private PlaceDAO placeDAO;

    @Autowired
    private PriceListDAO priceListDAO;

    @Autowired
    private TicketDAO ticketDAO;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Returns complete list of places.
     *
     * @return List<PlaceDTO>
     */
    @Override
    public List<PlaceDTO> getAllPlaces(){
        List<PlaceDTO> placeDTOs = new ArrayList<>();
        for(PlaceEntity list: placeDAO.getAll()){
            placeDTOs.add(convertToDto(list));
        }
        return placeDTOs;
    }

    /**
     * Returns complete list of event ralizations.
     *
     * @return List<EventRealizationDTO>
     */
    @Override
    public List<EventRealizationDTO> getAllEventRealization() {
        List<EventRealizationDTO> realizationDTOs = new ArrayList<>();
        for(EventRealizationEntity list: eventRealizationDAO.getAll()){
            realizationDTOs.add(convertToDto(list));
        }
        return realizationDTOs;
    }

    /**
     * Returns complete list of events.
     *
     * @return List<EventDTO>
     */
    public List<EventDTO> getAllEvents() {
        List<EventDTO> eventDTOs = new ArrayList<>();
        for(EventEntity list: eventDAO.getAll()){
            eventDTOs.add(convertToDto(list));
        }
        return eventDTOs;
    }

    /**
     * Adding event with given parms.
     *
     * @param eventName
     * @param eventTypeId
     * @param eventDescription
     */
    @Override
    public void addEvent(String eventName, Integer eventTypeId, String eventDescription){
        EventDTO event = new EventDTO();
        event.setName(eventName);
        event.setEventTypeId(eventTypeId);
        event.setDescription(eventDescription);
        eventDAO.addEvent(convertToEntity(event));
    }

    /**
     * Returms all event types
     *
     * @return List<EventTypeDTO>
     */
    public List<EventTypeDTO> getAllEventTypes() {
        List<EventTypeDTO> eventTypesDTOs = new ArrayList<>();
        for(EventTypeEntity list: eventTypeDAO.getAll()){
            eventTypesDTOs.add(convertToDto(list));
        }
        return eventTypesDTOs;
    }

    /**
     * Returns event with given id.
     *
     * @param id
     * @return EventDTO
     */
    @Override
    public EventDTO getEventById(Integer id) {
        return convertToDto(eventDAO.getEventById(id));
    }

    /**
     * Deletes event with given id.
     *
     * @param id
     */
    @Override
    public void deleteEvent(Integer id) {
        eventDAO.deleteEvent(id);
    }

    /**
     * Update event according to parms.
     *
     * @param eventId
     * @param eventName
     * @param eventType
     * @param eventDescription
     */
    @Override
    public void updateEvent(Integer eventId, String eventName, Integer eventType, String eventDescription) {
        EventDTO event = convertToDto(eventDAO.getEventById(eventId));
        event.setName(eventName);
        event.setEventTypeId(eventType);
        event.setDescription(eventDescription);
        eventDAO.updateEvent(convertToEntity(event));
    }

    /**
     * Returns all reservations of realization identified by id.
     *
     * @param id
     * @return List<ReservationDTO>
     */
    @Override
    public List<ReservationDTO> getAllEventReservationByRealization(int id) {
        List<ReservationDTO> reservationDTOs = new ArrayList<>();
        for(ReservationEntity list: reservationDAO.getAllReservationsByRealization(id)){
            reservationDTOs.add(convertToDto(list));
        }
        return reservationDTOs;
    }

    /**
     * Returns all event reservations.
     *
     * @return List<ReservationDTO>
     */
    @Override
    public List<ReservationDTO> getAllEventReservation() {
        List<ReservationDTO> reservationDTOs = new ArrayList<>();
        for(ReservationEntity list: reservationDAO.getAll()){
            reservationDTOs.add(convertToDto(list));
        }
        return reservationDTOs;
    }

    /**
     * Returns all buildings.
     *
     * @return List<BuildingDTO>
     */
    @Override
    public List<BuildingDTO> getAllBuildings() {
        List<BuildingDTO> buildingDTOs = new ArrayList<>();
        for(BuildingEntity list: buildingDAO.getAllBuildings()){
            buildingDTOs.add(convertToDto(list));
        }
        return buildingDTOs;
    }

    /**
     * Returns all rooms.
     *
     * @return List<RoomDTO>
     */
    @Override
    public List<RoomDTO> getAllRooms() {
        List<RoomDTO> roomDTOs = new ArrayList<>();
        for(RoomEntity list: roomDAO.getAllRooms()){
            roomDTOs.add(convertToDto(list));
        }
        return roomDTOs;
    }

    /**
     * Add realization described by parms.
     *
     * @param eventId
     * @param roomId
     * @param realizationDate
     * @param realizationTime
     */
    @Override
    public void addRealization(Integer eventId, Integer roomId, java.sql.Date realizationDate, Integer realizationTime){
        EventRealizationDTO eventRealization = new EventRealizationDTO();
        eventRealization.setEventId(eventId);
        eventRealization.setRoomId(roomId);
        eventRealization.setDate(realizationDate);
        eventRealization.setHour(realizationTime);
        eventRealizationDAO.addEventRealization(convertToEntity(eventRealization));
    }

    /**
     * Update reservation described by parms.
     *
     * @param realizationId
     * @param eventId
     * @param roomId
     * @param realizationDate
     * @param realizationHour
     */
    @Override
    public void updateRealization(Integer realizationId, Integer eventId, Integer roomId, java.sql.Date realizationDate, Integer realizationHour) {
        EventRealizationDTO eventRealization = convertToDto(eventRealizationDAO.getEventRealizationById(realizationId));
        eventRealization.setEventId(eventId);
        eventRealization.setRoomId(roomId);
        eventRealization.setDate(realizationDate);
        eventRealization.setHour(realizationHour);
        eventRealizationDAO.updateEventRealization(convertToEntity(eventRealization));
    }

    //TODO dlaczemu null?
    @Override
    public List<SectorDTO> getAllSectorsByRealizationId(int id) {
        return null;
    }

    /**
     * Get all reservations of event identified by id.
     *
     * @param id
     * @return List<ReservationDTO>
     */
    @Override
    public List<ReservationDTO> getAllEventReservation(Integer id) {
        List<ReservationDTO> reservationDTOs = new ArrayList<>();
        for(ReservationEntity list: reservationDAO.getAllReservations(id)){
            reservationDTOs.add(convertToDto(list));
        }
        return reservationDTOs;
    }

    /**
     * Returns reservation with given id.
     *
     * @param id
     * @return ReservationDTO
     */
    @Override
    public ReservationDTO getReservationById(Integer id) {
        return convertToDto(reservationDAO.getReservationById(id));
    }

    /**
     * Returns event realization with given id.
     *
     * @param id
     * @return EventRealizationDTO
     */
    @Override
    public EventRealizationDTO getEventRealizationById(Integer id) {
        return convertToDto(eventRealizationDAO.getEventRealizationById(id));
    }

    /**
     * Returns information of seats in room where realization is set.
     *
     * @param realizationId
     * @return List<SectorInfo>
     */
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
            List<TicketEntity> tickets = event.getTickets();
            for (int j = 0; j < reservations.size(); j++) {
                List<PlaceEntity> places = new ArrayList<>(reservations.get(j).getPlaces());
                for (int k = 0; k < places.size(); k++) {
                    if(places.get(k).getSectorId() == sectors.get(i).getSectorId()) {
                        sectorInfo.occupiedSeats.add(places.get(k).getNumber());
                    }
                }
            }
            for (int j = 0; j < tickets.size(); j++) {
                List<PlaceEntity> places = new ArrayList<>(tickets.get(j).getPlaces());
                for (int k = 0; k < places.size(); k++) {
                    if(places.get(k).getSectorId() == sectors.get(i).getSectorId()) {
                        sectorInfo.occupiedSeats.add(places.get(k).getNumber());
                    }
                }
            }
            roomInfo.add(sectorInfo);
        }
        return roomInfo;
    }

    /**
     * Returns converted list of seats.
     *
     * @param seats
     * @return List<PlaceDTO>
     */
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

    /**
     * Returns selecrteted seats converted to entity obiects.
     *
     * @param seats
     * @return List<PlaceEntity>
     */
    @Override
    public List<PlaceEntity> convertSelectedSeatsStringArrayToPlaceEntityList(String[] seats) {
        List<PlaceEntity> places = new ArrayList<>();
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
                            places.add(allSectorPlaces.get(j));
                        }
                    }
                }
            }
        }
        return places;
    }

    /**
     * Returns list of places from list of ids.
     *
     * @param placeIds
     * @return List<PlaceDTO>
     */
    @Override
    public List<PlaceDTO> getPlaceListFromIds(String[] placeIds) {
        List<PlaceDTO> placeList = new ArrayList<>();
        for (int i = 0; i < placeIds.length; i++) {
            placeList.add(convertToDto(placeDAO.getPlaceById(Integer.parseInt(placeIds[i]))));
        }
        return placeList;
    }

    /**
     * Add reservation described by parms.
     *
     * @param reservation
     * @param eventRealization
     * @param selectedPlaces
     */
    @Override
    public void addReservation(ReservationDTO reservation, EventRealizationDTO eventRealization, List<PlaceDTO> selectedPlaces){
        reservation.setEventRealizationId(eventRealization.getEventRealizationId());
        reservation.setPlaces(convertToEntity(selectedPlaces));
        reservation.setEventRealization(convertToEntity(eventRealization));
        reservation.setDate(new GregorianCalendar().getTime());
        reservationDAO.addReservation(convertToEntity(reservation));
    }

    /**
     * Add ticket described by parsm.
     *
     * @param eventRealization
     * @param selectedPlaces
     */
    @Override
    public void addTicket(EventRealizationDTO eventRealization, List<PlaceDTO> selectedPlaces) {
        TicketEntity ticket = new TicketEntity();
        ticket.setEventRealizationId(eventRealization.getEventRealizationId());
        ticket.setEventRealization(convertToEntity(eventRealization));
        ticket.setPlaces(convertToEntity(selectedPlaces));
        //TODO: dodac cos jeszcze ewentualnie
        ticketDAO.addTicket(ticket);
    }

    /**
     * Update reservation identified by id according to parms.
     *
     * @param reservationId
     * @param reservation
     */
    @Override
    public void updateReservation(Integer reservationId, ReservationDTO reservation) {
        ReservationDTO dto = convertToDto(reservationDAO.getReservationById(reservationId));
        reservation.setEventRealization(dto.getEventRealization());
        reservation.setPlaces(dto.getPlaces());
        reservation.setDate(dto.getDate());
        reservationDAO.updateReservation(convertToEntity(reservation));
    }

    /**
     * Delete event realization identified by id.
     *
     * @param id
     */
    @Override
    public void deleteEventRealization(Integer id) {
        eventRealizationDAO.deleteEventRealization(id);
    }

    /**
     * Returns price list to event identified by id and in given date.
     *
     * @param eventId
     * @param date
     * @return PriceListEntity
     */
    @Override
    public PriceListEntity getPriceListForEvent(Integer eventId, Date date) {
        return priceListDAO.findByEventIdAndDate(eventId, date);
//        for(int i = 0; i < priceListEntityList.size(); i++) {
//            if(date.after(priceListEntityList.get(i).getFrom()) && date.before(priceListEntityList.get(i).getTo())) {
//                return priceListEntityList.get(i);
//            }
//        }
//        return null;
    }

    /**
     * Delete reservation identified by id.
     *
     * @param id
     */
    @Override
    public void deleteReservation(Integer id) {
        reservationDAO.deleteReservation(id);
    }

    /**
     * Returns all price lists.
     *
     * @return List<PriceListDTO>
     */
    @Override
    public List<PriceListDTO> getAllPriceList() {
        List<PriceListDTO> priceListDTOs = new ArrayList<>();
        for (PriceListEntity list : priceListDAO.getAll()) {
            priceListDTOs.add(convertToDto(list));
        }
        return priceListDTOs;
    }

    /**
     * Returns price list identified by id.
     *
     * @param id
     * @return PriceListDTO
     */
    @Override
    public PriceListDTO getPriceListById(Integer id) {
        return convertToDto(priceListDAO.getPriceListById(id));
    }

    /**
     * Delete price list identified by id.
     *
     * @param id
     */
    @Override
    public void deletePriceList(Integer id) {
        priceListDAO.deletePriceList(id);
    }

    /**
     * Update price list identified by id according to parms.
     *
     * @param priceListID
     * @param priceList
     */
    @Override
    public void updatePriceList(Integer priceListID, PriceListDTO priceList) {
        PriceListDTO dto = convertToDto(priceListDAO.getPriceListById(priceListID));
        priceList.setFrom(dto.getFrom());
        priceList.setTo(dto.getTo());
        priceList.setName(dto.getName());
        priceList.setEventId(dto.getEventId());
        priceListDAO.updatePriceList(convertToEntity(priceList));
    }

    /**
     * Convert Entity object to DTO object
     * @param buildingEntity
     * @return BuildingDTO
     */
    private BuildingDTO convertToDto(BuildingEntity buildingEntity) {
        return modelMapper.map(buildingEntity, BuildingDTO.class);
    }

    /**
     * Convert Entity object to DTO object
     *
     * @param roomEntity
     * @return RoomDTO
     */
    private RoomDTO convertToDto(RoomEntity roomEntity) {
        return modelMapper.map(roomEntity, RoomDTO.class);
    }

    /**
     * Update price list identified by id according to given parms.
     *
     * @param priceListId
     * @param priceListFrom
     * @param priceListTo
     * @param priceListName
     * @param eventId
     */
    @Override
    public void updatePriceList(Integer priceListId, String priceListFrom, String priceListTo, String priceListName, Integer eventId) {
        PriceListDTO priceList = convertToDto(priceListDAO.getPriceListById(priceListId));
        priceList.setFrom(DateConverter.getInstance().stringToDate(priceListFrom));
        priceList.setTo(DateConverter.getInstance().stringToDate(priceListTo));
        priceList.setName(priceListName);
        priceList.setEventId(eventId);
        priceListDAO.updatePriceList(convertToEntity(priceList));
    }

    /**
     * Add price list according to given parms.
     *
     * @param priceListFrom
     * @param priceListTo
     * @param priceListName
     * @param eventId
     */
    @Override
    public void addPriceList(String priceListFrom, String priceListTo, String priceListName, Integer eventId) {
        PriceListDTO priceList = new PriceListDTO();
        priceList.setFrom(DateConverter.getInstance().stringToDate(priceListFrom));
        priceList.setTo(DateConverter.getInstance().stringToDate(priceListTo));
        priceList.setName(priceListName);
        priceList.setEventId(eventId);
        priceListDAO.addPriceList(convertToEntity(priceList));
    }

    /**
     * Convert Entity object to DTO object
     *
     * @param priceListEntity
     * @return PriceListDTO
     */
    private PriceListDTO convertToDto(PriceListEntity priceListEntity) {
        return modelMapper.map(priceListEntity, PriceListDTO.class);
    }

    /**
     * Convert Entity object to DTO object
     * @param eventEntity
     * @return EventDTO
     */
    private EventDTO convertToDto(EventEntity eventEntity) {
        return modelMapper.map(eventEntity, EventDTO.class);
    }

    /**
     * Convert Entity object to DTO object
     *
     * @param eventTypeEntity
     * @return EventTypeDTO
     */
    private EventTypeDTO convertToDto(EventTypeEntity eventTypeEntity) {
        return modelMapper.map(eventTypeEntity, EventTypeDTO.class);
    }

    /**
     * Convert Entity object to DTO object
     *
     * @param placeEntity
     * @return PlaceDTO
     */
    private PlaceDTO convertToDto(PlaceEntity placeEntity) {
        PlaceDTO place = modelMapper.map(placeEntity, PlaceDTO.class);
        return place;
    }

    /**
     * Convert Entity object to DTO object
     * @param reservationEntity
     * @return ReservationDTO
     */
    private ReservationDTO convertToDto(ReservationEntity reservationEntity) {
        ReservationDTO reservationDTO = modelMapper.map(reservationEntity, ReservationDTO.class);
        return reservationDTO;
    }

    /**
     * Convert place list from list of dtos to list of entities.
     *
     * @param placeDTOList
     * @return  List<PlaceEntity>
     */
    @Override
    public List<PlaceEntity> convertToEntity(List<PlaceDTO> placeDTOList) {
        List<PlaceEntity> places = new ArrayList<>();
        for(PlaceDTO p: placeDTOList){
            places.add(modelMapper.map(p, PlaceEntity.class));
        }
        return places;
    }

    /**
     * Convert reservations from list of dtos to list of entities.
     *
     * @param reservationDTOs
     * @return List<ReservationEntity>
     */
    private List<ReservationEntity> convertToEntity1(List<ReservationDTO> reservationDTOs) {
        List<ReservationEntity> reservations = new ArrayList<>();
        for(ReservationDTO r: reservationDTOs){
            reservations.add(modelMapper.map(r, ReservationEntity.class));
        }
        return reservations;
    }

    /**
     * Convert dto obiect to entity object.
     *
     * @param ticketDTO
     * @return TicketEntity
     * @throws ParseException
     */
    private TicketEntity convertToEntity(TicketDTO ticketDTO) throws ParseException {
        return modelMapper.map(ticketDTO, TicketEntity.class);
    }

    /**
     * Convert dto obiect to entity object.
     *
     * @param eventDTO
     * @return EventEntity
     * @throws ParseException
     */
    private EventEntity convertToEntity(EventDTO eventDTO) throws ParseException {
        return modelMapper.map(eventDTO, EventEntity.class);
    }

    /**
     * Convert dto obiect to entity object.
     *
     * @param placeDTO
     * @return PlaceEntity
     * @throws ParseException
     */
    private PlaceEntity convertToEntity(PlaceDTO placeDTO) throws ParseException {
        PlaceEntity placeEntity = modelMapper.map(placeDTO, PlaceEntity.class);
        return placeEntity;
    }

    /**
     * Convert dto obiect to entity object.
     *
     * @param reservationDTO
     * @return ReservationEntity
     * @throws ParseException
     */
    private ReservationEntity convertToEntity(ReservationDTO reservationDTO) throws ParseException {
        ReservationEntity reservation = modelMapper.map(reservationDTO, ReservationEntity.class);
        return reservation;
    }

    /**
     * Convert dto obiect to entity object.
     *
     * @param priceListDTO
     * @return PriceListEntity
     * @throws ParseException
     */
    private PriceListEntity convertToEntity(PriceListDTO priceListDTO) throws ParseException {
        PriceListEntity priceList = modelMapper.map(priceListDTO, PriceListEntity.class);
        return priceList;
    }

    /**
     * Convert Entity object to DTO object
     *
     * @param eventRealizationEntity
     * @return EventRealizationDTO
     */
    private EventRealizationDTO convertToDto(EventRealizationEntity eventRealizationEntity) {
        EventRealizationDTO postDto = modelMapper.map(eventRealizationEntity, EventRealizationDTO.class);
        return postDto;
    }

    /**
     * Convert dto obiect to entity object.
     *
     * @param eventRealization
     * @return EventRealizationEntity
     */
    @Override
    public EventRealizationEntity convertToEntity(EventRealizationDTO eventRealization) {
        EventRealizationEntity realizationEntity = modelMapper.map(eventRealization, EventRealizationEntity.class);
        return realizationEntity;
    }
}
