package terletskayasamuseva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showWelcomePage(){
        return "main";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String showAuthorizationPage(){
        return "static/login";
        return "login";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String showRegistrationPage(){
        return "registration";
    }

}
