package com.springapp.mvc;

import com.springapp.guest.Guest;
import com.springapp.guest.GuestService;
import com.springapp.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

/**
 * Controller for welcome page.
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/", method = RequestMethod.POST,
            produces = "text/html;charset=UTF-8",
            params = {"sex", "nameGuest"})
    public ModelAndView printWelcome(@RequestParam(value = "sex") String sex,
                                     @RequestParam(value = "nameGuest") String nameGuest,
                                     @RequestParam(value = "showSex", required = false) Boolean showSex,
                                     ModelMap model) throws UnsupportedEncodingException {

        if (TextUtils.isLetterSymbols(nameGuest)){

            Guest guest = new Guest();
            guest.setName(nameGuest);
            guest.setSex(sex);

            if (guestService.findGuest(nameGuest) == null){
                guestService.addGuest(guest);
            }

            String message = MESSAGE_WELCOME + " ";

            if (showSex != null)
                message += sex + " ";

            message += nameGuest;

            model.addAttribute("showAlert", true);
            model.addAttribute("message", message);
        }else{
            model.addAttribute("showError", true);
            model.addAttribute("message", MESSAGE_INCORRECT_NAME);
        }

        return new ModelAndView("welcome", model);
    }

    /**
     * Welcome message.
     */
    private final String MESSAGE_WELCOME = "Hello";

    /**
     * Const for incorrect name.
     */
    private final String MESSAGE_INCORRECT_NAME = "Incorrect name.";

    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = "text/html", params = {})
    public ModelAndView welcome(ModelMap model) {
        model.addAttribute("showAlert", false);
        model.addAttribute("showError", false);

        return new ModelAndView("welcome", model);
    }
}