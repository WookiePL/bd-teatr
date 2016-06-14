package theater.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import theater.helper.SectorInfo;
import theater.persist.dtos.EventRealizationDTO;
import theater.persist.dtos.PlaceDTO;
import theater.persist.dtos.ReservationDTO;
import theater.persist.dtos.RoomDTO;
import theater.services.IEventService;

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
    public String deleteEventReservation(Model model,
                                         @RequestParam(value = "realizationId", required = true) Integer realizationID,
                                         @RequestParam(value = "reservationId", required = true) Integer reservationId) {
        eventService.deleteReservation(reservationId);
        return "redirect:/eventReservations?realizationId=" + realizationID;
    }

    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/editReservation"}, method = RequestMethod.GET)
    public String editReservation(Model model, @RequestParam(value = "reservationId", required = false) Integer reservationID) {
        ReservationDTO reservation = eventService.getReservationById(reservationID);
        if (reservation != null) {
            EventRealizationDTO event = eventService.getEventRealizationById(reservation.getReservationId());
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
    public String editReservation(@ModelAttribute(value = "reservation") ReservationDTO reservation, BindingResult
            result) {
        if (result.hasErrors()) {
            return "redirect:/editReservation?reservationId=" + reservation.getReservationId();
        }
        eventService.updateReservation(reservation);
        return "redirect:/eventReservations?realizationId=" + reservation.getEventRealizationId();
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
    @RequestMapping(value = {"/tickets"}, method = RequestMethod.POST)
    public String tickets(Model model, @RequestParam("seats") String[] seats, @RequestParam("realizationId") String realizationId) {
        Integer realizationIdInt = Integer.parseInt(realizationId);
        List<PlaceDTO> selectedPlaces = eventService.convertSelectedSeatsStringArrayToPlaceList(seats);
        EventRealizationDTO eventRealization = eventService.getEventRealizationById(realizationIdInt);
        if (eventRealization != null) {
            model.addAttribute("eventDescription", eventRealization);
            model.addAttribute("places", selectedPlaces); //TODO: nie wiem czy nie potrzeba jeszcze wysłać sektoru
            return "tickets";
        }
        return "redirect:/eventRealizations";
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
            model.addAttribute("reservation", reservation);
            model.addAttribute("places", selectedPlaces); //TODO: nie wiem czy nie potrzeba jeszcze wysłać sektoru
            return "createReservation";
        }
        return "redirect:/eventRealizations";
    }

    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/roomInfo"}, method = RequestMethod.GET)
    public @ResponseBody
    List<SectorInfo> roomInfo(Model model, @RequestParam(value = "realizationId", required = false) Integer realizationId) {
        List<SectorInfo> roomInfo = eventService.getRoomInfo(realizationId);
        return roomInfo;
    }

    //TODO: przerobić na wejście do biletów z rezerwacji
    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/tickets"}, method = RequestMethod.GET)
    public String tickets(Model model, @RequestParam(value = "realizationId", required = false) Integer realizationId) {
        EventRealizationDTO eventRealization = eventService.getEventRealizationById(realizationId);
        if (eventRealization != null) {
            ReservationDTO reservation = new ReservationDTO();
            model.addAttribute("eventDescription", eventRealization);
            return "tickets";
        }
        return "eventRealization";
    }
}
