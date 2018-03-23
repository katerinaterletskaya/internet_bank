package terletskayasamuseva.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import terletskayasamuseva.UserService;
import terletskayasamuseva.model.UserDTO;
import terletskayasamuseva.validator.UserValidator;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    public static final Logger logger = Logger.getLogger(RegistrationController.class);

    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public RegistrationController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String openRegisterUserPage() {
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute UserDTO user, Model model) {
        logger.info(user.toString());
        if ( userService.getUserByEmail(user.getUsername()) != null ) {
            model.addAttribute("usernameError", "Пользователь с таким адресом уже существует!");
            return "registration";
        } else {
            userService.save(user);
            return "user/main";
        }
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }
}
