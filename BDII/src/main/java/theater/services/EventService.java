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

import java.util.*;

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
    private PlaceDAO placeDAO;

    @Autowired
    private PriceListDAO priceListDAO;

    @Autowired
    private TicketDAO ticketDAO;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<PlaceDTO> getAllPlaces(){
        List<PlaceDTO> placeDTOs = new ArrayList<>();
        for(PlaceEntity list: placeDAO.getAll()){
            placeDTOs.add(convertToDto(list));
        }
        return placeDTOs;
    }

    @Override
    public List<EventRealizationDTO> getAllEventRealization() {
        List<EventRealizationDTO> realizationDTOs = new ArrayList<>();
        for(EventRealizationEntity list: eventRealizationDAO.getAll()){
            realizationDTOs.add(convertToDto(list));
        }
        return realizationDTOs;
    }

    @Override
    public List<PriceListDTO> getAllPriceList() {
        List<PriceListDTO> priceListDTOs = new ArrayList<>();
        for(PriceListEntity list: priceListDAO.getAll()){
            priceListDTOs.add(convertToDto(list));
        }
        return priceListDTOs;
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

    @Override
    public List<PlaceDTO> getPlaceListFromIds(String[] placeIds) {
        List<PlaceDTO> placeList = new ArrayList<>();
        for (int i = 0; i < placeIds.length; i++) {
            placeList.add(convertToDto(placeDAO.getPlaceById(Integer.parseInt(placeIds[i]))));
        }
        return placeList;
    }

    @Override
    public void addReservation(ReservationDTO reservation, EventRealizationDTO eventRealization, List<PlaceDTO> selectedPlaces){
        reservation.setEventRealizationId(eventRealization.getEventRealizationId());
        reservation.setPlaces(convertToEntity(selectedPlaces));
        reservation.setEventRealization(convertToEntity(eventRealization));
        reservation.setDate(new GregorianCalendar().getTime());
        reservationDAO.addReservation(convertToEntity(reservation));
    }

    @Override
    public void addTicket(EventRealizationDTO eventRealization, List<PlaceDTO> selectedPlaces) {
        TicketEntity ticket = new TicketEntity();
        ticket.setEventRealizationId(eventRealization.getEventRealizationId());
        ticket.setEventRealization(convertToEntity(eventRealization));
        ticket.setPlaces(convertToEntity(selectedPlaces));
        //TODO: dodac cos jeszcze ewentualnie
        ticketDAO.addTicket(ticket);
    }

    @Override
    public void updateReservation(Integer reservationId, ReservationDTO reservation) {
        ReservationDTO dto = convertToDto(reservationDAO.getReservationById(reservationId));
        reservation.setEventRealization(dto.getEventRealization());
        reservation.setPlaces(dto.getPlaces());
        reservation.setDate(dto.getDate());
        reservationDAO.updateReservation(convertToEntity(reservation));
    }


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

    @Override
    public void deleteReservation(Integer id) {
        reservationDAO.deleteReservation(id);
    }

    private PriceListDTO convertToDto(PriceListEntity priceListEntity) {
        return modelMapper.map(priceListEntity, PriceListDTO.class);
    }

    private PlaceDTO convertToDto(PlaceEntity placeEntity) {
        PlaceDTO place = modelMapper.map(placeEntity, PlaceDTO.class);
        return place;
    }

    private ReservationDTO convertToDto(ReservationEntity reservationEntity) {
        ReservationDTO reservationDTO = modelMapper.map(reservationEntity, ReservationDTO.class);
        return reservationDTO;
    }

    @Override
    public List<PlaceEntity> convertToEntity(List<PlaceDTO> placeDTOList) {
        List<PlaceEntity> places = new ArrayList<>();
        for(PlaceDTO p: placeDTOList){
            places.add(modelMapper.map(p, PlaceEntity.class));
        }
        return places;
    }

    private List<ReservationEntity> convertToEntity1(List<ReservationDTO> reservationDTOs) {
        List<ReservationEntity> reservations = new ArrayList<>();
        for(ReservationDTO r: reservationDTOs){
            reservations.add(modelMapper.map(r, ReservationEntity.class));
        }
        return reservations;
    }

    private TicketEntity convertToEntity(TicketDTO ticketDTO) throws ParseException {
        return modelMapper.map(ticketDTO, TicketEntity.class);
    }

    private PlaceEntity convertToEntity(PlaceDTO placeDTO) throws ParseException {
        PlaceEntity placeEntity = modelMapper.map(placeDTO, PlaceEntity.class);
        return placeEntity;
    }

    private ReservationEntity convertToEntity(ReservationDTO reservationDTO) throws ParseException {
        ReservationEntity reservation = modelMapper.map(reservationDTO, ReservationEntity.class);
        return reservation;
    }

    private EventRealizationDTO convertToDto(EventRealizationEntity eventRealizationEntity) {
        EventRealizationDTO postDto = modelMapper.map(eventRealizationEntity, EventRealizationDTO.class);
        return postDto;
    }

    @Override
    public EventRealizationEntity convertToEntity(EventRealizationDTO eventRealization) {
        EventRealizationEntity realizationEntity = modelMapper.map(eventRealization, EventRealizationEntity.class);
        return realizationEntity;
    }
}
