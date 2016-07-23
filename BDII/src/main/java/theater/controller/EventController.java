package theater.controller;

import com.google.gson.Gson;
import com.sun.javafx.collections.ObservableListWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import theater.helper.SectorInfo;
import theater.persist.daos.EventRealizationDAO;
import theater.persist.daos.PlaceDAO;
import theater.persist.dtos.*;
import theater.persist.model.PlaceEntity;
import theater.persist.model.PriceListEntity;
import theater.services.IEventService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


@Controller
public class EventController {

    @Autowired
    private IEventService eventService;

    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/eventRealizations"}, method = RequestMethod.GET)
    public String eventRealizations(Model model) {
        model.addAttribute("eventRealizationList", eventService.getAllEventRealization());
        return "eventRealizations";
    }

    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/eventReservations"}, method = RequestMethod.GET)
    public String eventReservations(Model model, @RequestParam(value = "realizationId", required = true) Integer realizationID) {

        model.addAttribute("eventReservationList", eventService.getAllEventReservationByRealization(realizationID));
        model.addAttribute("eventDescription", eventService.getEventRealizationById(realizationID));
        return "eventReservations";
    }

    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/deleteEventReservation"}, method = RequestMethod.GET)
    public String deleteEventReservation(@RequestParam(value = "realizationId", required = true) Integer realizationID,
                                         @RequestParam(value = "reservationId", required = true) Integer reservationId) {
        eventService.deleteReservation(reservationId);
        return "redirect:/eventReservations?realizationId=" + realizationID;
    }


    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/selectSeats"}, method = RequestMethod.GET)
    public String selectSeats(Model model, @RequestParam(value = "realizationId", required = false) Integer realizationId) {
        EventRealizationDTO eventRealization = eventService.getEventRealizationById(realizationId);
        if (eventRealization != null) {
            model.addAttribute("event", eventRealization);
            return "selectSeats";
        }
        return "eventReservations";
    }



    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/createReservation"}, method = RequestMethod.POST)
    public String createReservation(Model model, @RequestParam("seats") String[] seats, @RequestParam("realizationId") String realizationId) {
        Integer realizationIdInt = Integer.parseInt(realizationId);
        List<PlaceDTO> selectedPlaces = eventService.convertSelectedSeatsStringArrayToPlaceList(seats);
        EventRealizationDTO eventRealization = eventService.getEventRealizationById(realizationIdInt);
        if (eventRealization != null) {
            ReservationDTO reservation = new ReservationDTO();
            model.addAttribute("event", eventRealization);
            model.addAttribute("placesList", selectedPlaces);
            model.addAttribute("reservation", reservation);

            model.addAttribute("seats", seats);
            model.addAttribute("realizationId", realizationId);
            return "createReservation";
        }
        return "redirect:/eventRealizations";
    }

    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/addReservation"}, method = RequestMethod.POST)
    public String addReservation(@RequestParam("seats") String[] seats, @RequestParam("realizationId") String realizationId,
                                 @ModelAttribute(value = "reservation") ReservationDTO reservation, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/editReservation?reservationId=" + reservation.getReservationId();
        }
        Integer realizationIdInt = Integer.parseInt(realizationId);
        List<PlaceDTO> selectedPlaces = eventService.convertSelectedSeatsStringArrayToPlaceList(seats);
        EventRealizationDTO eventRealization = eventService.getEventRealizationById(realizationIdInt);
        if (eventRealization != null) {
            eventService.addReservation(reservation, eventRealization, selectedPlaces);//wysyłam miejsca
        }
        return "redirect:/eventReservations?realizationId=" + reservation.getEventRealizationId();
    }

    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/editReservation"}, method = RequestMethod.GET)
    public String editReservation(Model model, @RequestParam(value = "reservationId", required = false) Integer reservationID) {
        ReservationDTO reservation = eventService.getReservationById(reservationID);
        if (reservation != null) {
            EventRealizationDTO event = eventService.getEventRealizationById(reservation.getEventRealizationId());
            if (event != null) {
                model.addAttribute("reservation", reservation);
                model.addAttribute("event", event);
            }
            return "editReservation";
        }
        return "eventRealizations";
    }

    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/editReservation"}, method = RequestMethod.POST)
    public String editReservation(@RequestParam(value = "reservationId", required = false) Integer reservationID,
                                  @ModelAttribute(value = "reservation") ReservationDTO newReservation, BindingResult result) {
        ReservationDTO reservation = eventService.getReservationById(reservationID);
        if (result.hasErrors()) {
            return "redirect:/editReservation?reservationId=" + reservation.getReservationId();
        }
        eventService.updateReservation(reservationID, newReservation);
        return "redirect:/eventReservations?realizationId=" + reservation.getEventRealizationId();
    }

    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/roomInfo"}, method = RequestMethod.GET)
    public
    @ResponseBody
    List<SectorInfo> roomInfo(Model model, @RequestParam(value = "realizationId", required = false) Integer realizationId) {
        List<SectorInfo> roomInfo = eventService.getRoomInfo(realizationId);
        return roomInfo;
    }

    //wejscie w bilety z rezerwacji
    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/tickets"}, method = RequestMethod.GET)
    public String tickets(Model model, @RequestParam(value = "reservationId", required = false) Integer reservationId) {
        ReservationDTO reservation = eventService.getReservationById(reservationId);
        EventRealizationDTO eventRealization = eventService.getEventRealizationById(reservation.getEventRealizationId());
        PriceListEntity priceList = eventService.getPriceListForEvent(eventRealization.getEvent().getEventId(), eventRealization.getDate());
        model.addAttribute("priceList", priceList);
        model.addAttribute("numberOfTickets", reservation.getPlaces().size());
        model.addAttribute("places", reservation.getPlaces());
        model.addAttribute("reservationId", reservation.getReservationId());
        model.addAttribute("eventDescription", eventRealization);
        return "tickets";
    }

    //wejscie w bilety z wyboru miejsc
    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/tickets"}, method = RequestMethod.POST)
    public String tickets(Model model, @RequestParam("seats") String[] seats, @RequestParam("realizationId") String realizationId) {
        Integer realizationIdInt = Integer.parseInt(realizationId);
        List<PlaceEntity> selectedPlaces = eventService.convertSelectedSeatsStringArrayToPlaceEntityList(seats);
        EventRealizationDTO eventRealization = eventService.getEventRealizationById(realizationIdInt);
        PriceListEntity priceList = eventService.getPriceListForEvent(eventRealization.getEvent().getEventId(), eventRealization.getDate());
        Integer reservationId = -1;
        if (selectedPlaces.size() != 0) {
            model.addAttribute("priceList", priceList);
            model.addAttribute("numberOfTickets", selectedPlaces.size());
            model.addAttribute("places", selectedPlaces);
            model.addAttribute("reservationId", reservationId); // -1 means there's no reservation
            model.addAttribute("eventDescription", eventRealization);
            return "tickets";
        }
        return "redirect:/eventRealizations";
    }

    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/addTickets"}, method = RequestMethod.POST)
    public String addTickets(Model model, @RequestParam("placeIds") String[] placeIds, @RequestParam("realizationId") String realizationId,
                             @RequestParam("reservationId") String reservationId) {
        if(Integer.parseInt(reservationId) != -1) {
            eventService.deleteReservation(Integer.parseInt(reservationId));
        }
        List<PlaceDTO> placeList = eventService.getPlaceListFromIds(placeIds);
        EventRealizationDTO eventRealization = eventService.getEventRealizationById(Integer.parseInt(realizationId));
        eventService.addTicket(eventRealization, placeList);
        return "redirect:/eventRealizations";
    }


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setAutoGrowCollectionLimit(500);
    }
}
