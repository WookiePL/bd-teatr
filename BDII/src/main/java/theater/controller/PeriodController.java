package theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import theater.helper.DayOfWeekHelper;
import theater.persist.dtos.CycleDTO;
import theater.persist.dtos.DayOfWeekDTO;
import theater.persist.dtos.PeriodDTO;
import theater.services.IPeriodService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wookie on 2016-07-31.
 */
@Controller
public class PeriodController {

    @Autowired
    private IPeriodService periodService;

    @PreAuthorize("hasRole('ROLE_STAFF')")
    @RequestMapping(value = {"/periods"}, method = RequestMethod.GET)
    public String periods(Model model) {
        model.addAttribute("periods", periodService.getAllPeriods());
        return "periods";
    }

    @PreAuthorize("hasRole('ROLE_STAFF')")
    @RequestMapping(value = {"/addPeriod"}, method = RequestMethod.GET)
    public String addPeriod(Model model, @RequestParam(value = "cycleId", required = false) String cycleId) {
        model.addAttribute("periods", periodService.getAllPeriods());
        model.addAttribute("daysOfWeek", periodService.getAllDaysOfWeek());
        CycleDTO cycleDTO = new CycleDTO();
        model.addAttribute("cycle", cycleDTO);
        return "addPeriod";
    }

    @PreAuthorize("hasRole('ROLE_STAFF')")
    @RequestMapping(value = {"/editPeriod"}, method = RequestMethod.GET)
    public String editPeriod(Model model, @RequestParam(value = "periodId", required = false) Integer periodId) {
        model.addAttribute("periods", periodService.getAllPeriods());
        DayOfWeekHelper dayOfWeekHelper = new DayOfWeekHelper();
        List<DayOfWeekDTO> checkedDaysOfWeek = new ArrayList<DayOfWeekDTO>();
        dayOfWeekHelper.setCheckedDaysOfWeek(checkedDaysOfWeek);

        model.addAttribute("daysOfWeek", periodService.getAllDaysOfWeek());
        model.addAttribute("checkedDaysOfWeek", dayOfWeekHelper);

        PeriodDTO period = periodService.getPeriodById(periodId);
        if (period != null) {
            model.addAttribute("period", period);
        }
       /* CycleDTO cycleDTO = new CycleDTO();
        model.addAttribute("cycle", cycleDTO);*/

        return "editPeriod";
    }

/*
    @PreAuthorize("hasRole('ROLE_STAFF')")
    @RequestMapping(value = {"/addPriceList"}, method = RequestMethod.POST)
    public String addPeriod(@RequestParam("periodName") String periodName, @RequestParam("priceListTo") String priceListTo, @RequestParam("priceListName") String priceListName, @RequestParam("event") String event) {
        Integer eventId = Integer.parseInt(event);
        eventService.addPriceList(priceListFrom, priceListTo,priceListName, eventId);
        return "redirect:/priceList";
}*/


}
