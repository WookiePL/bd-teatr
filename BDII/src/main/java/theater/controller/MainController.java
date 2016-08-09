package theater.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import theater.persist.daos.BuildingDAO;
import theater.persist.model.BuildingEntity;
import theater.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class MainController {

    @Autowired
    private IEventService eventService;
/*
    @Autowired
    private IPeriodService periodService;*/

    @PreAuthorize("hasRole('ROLE_CASHIER') or hasRole('ROLE_STAFF')")
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {

        return "home";
    }



    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
