package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import theater.persist.dtos.EventRealizationDTO;
import theater.persist.dtos.ReservationDTO;
import theater.services.IEventService;

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
    public String eventReservations(Model model, @RequestParam(value = "reservationId", required = false) Integer reservationID) {
        if (reservationID == null) {
            model.addAttribute("eventReservationList", eventService.getAllEventReservation());
        } else {
            ReservationDTO reservation = eventService.getReservationById(reservationID);
            if (reservation != null) {
                model.addAttribute("eventReservationList", eventService.getAllEventReservation(reservation.getReservationId()));
            }
        }
        return "eventReservations";
    }


    @PreAuthorize("hasRole('ROLE_CASHIER')")
    @RequestMapping(value = {"/editReservation"}, method = RequestMethod.GET)
    public String editReservation(Model model, @RequestParam(value = "reservationId", required = false) Integer
            reservationID) {
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
        return "redirect:/eventReservations";
    }


}
