package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "text/html",
            params = {"sex", "nameGuest"})
    public ModelAndView printWelcome(@RequestParam(value = "sex") String sex,
                                     @RequestParam(value = "nameGuest") String nameGuest,
                                     @RequestParam(value = "showSex", required = false) Boolean showSex,
                                     ModelMap model) {

        String message = "";

        model.addAttribute("showAlert", true);
        model.addAttribute("message", message);

        return new ModelAndView("welcome", model);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html",
            params = {})
    public ModelAndView welcome(ModelMap model) {
        model.addAttribute("showAlert", true);

        String message = "";
        model.addAttribute("message", message);

        return new ModelAndView("welcome", model);
    }
}