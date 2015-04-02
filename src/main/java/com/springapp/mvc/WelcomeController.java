package com.springapp.mvc;

import com.springapp.guest.Guest;
import com.springapp.manager.ManagerGuestImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "text/html",
            params = {"sex", "nameGuest"})
    public ModelAndView printWelcome(@RequestParam(value = "sex") String sex,
                                     @RequestParam(value = "nameGuest") String nameGuest,
                                     @RequestParam(value = "showSex", required = false) Boolean showSex,
                                     ModelMap model) {

        String message = "Hello ";

        if (showSex != null)
            message += sex;

        message += nameGuest;

        model.addAttribute("showAlert", true);
        model.addAttribute("message", message);

        Guest guest = new Guest();
        guest.setName(nameGuest);
        guest.setSex(sex);

        ManagerGuestImpl managerGuest = new ManagerGuestImpl();
        managerGuest.addGuest(guest);

        return new ModelAndView("welcome", model);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html",
            params = {})
    public ModelAndView welcome(ModelMap model) {
        model.addAttribute("showAlert", true);
        ManagerGuestImpl manager = new ManagerGuestImpl();
        List<Guest> guests = manager.getAll();

        String message = "";
        for (Guest guest : guests) {
            message += guest.toString();
        }
        model.addAttribute("message", message);

        return new ModelAndView("welcome", model);
    }
}