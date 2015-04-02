package com.springapp.mvc;

import com.springapp.guest.Guest;
import com.springapp.manager.ManagerGuestImpl;
import com.springapp.utils.TextUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "text/html;charset=UTF-8",
            params = {"sex", "nameGuest"})
    public ModelAndView printWelcome(@RequestParam(value = "sex") String sex,
                                     @RequestParam(value = "nameGuest") String nameGuest,
                                     @RequestParam(value = "showSex", required = false) Boolean showSex,
                                     ModelMap model) throws UnsupportedEncodingException {

        if (TextUtils.isLetterSymbols(nameGuest)){

            Guest guest = new Guest();
            guest.setName(nameGuest);
            guest.setSex(sex);

            ManagerGuestImpl manager = new ManagerGuestImpl();

            if (!manager.isVisited(guest)){
                manager.addGuest(guest);
            }

            String message = "Hello ";

            if (showSex != null)
                message += sex + " ";

            message += nameGuest;

            model.addAttribute("showAlert", true);
            model.addAttribute("showError", false);
            model.addAttribute("message", message);
        }else{
            model.addAttribute("showAlert", false);
            model.addAttribute("showError", true);
            model.addAttribute("message", "Incorrect name.");
        }

        return new ModelAndView("welcome", model);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html",
            params = {})
    public ModelAndView welcome(ModelMap model) {
        model.addAttribute("showAlert", false);
        model.addAttribute("showError", false);

        return new ModelAndView("welcome", model);
    }
}