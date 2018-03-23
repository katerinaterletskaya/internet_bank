package terletskayasamuseva.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import terletskayasamuseva.UserService;
import terletskayasamuseva.model.UserDTO;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String openUserMainPage(HttpSession session) {
        UserDTO user = userService.getUser((String) session.getAttribute("user"));
        session.setAttribute("fullName", user.getName()+" "+user.getPatronymic());
        return "user/main";
    }
}
