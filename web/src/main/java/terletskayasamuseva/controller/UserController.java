package terletskayasamuseva.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import terletskayasamuseva.OperationService;
import terletskayasamuseva.UserService;
import terletskayasamuseva.model.CurrencyKursDTO;
import terletskayasamuseva.model.UserDTO;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    private final UserService userService;
    private final OperationService operationService;

    @Autowired
    public UserController(UserService userService, OperationService operationService) {
        this.userService = userService;
        this.operationService = operationService;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String openUserMainPage(HttpSession session, Model model) {
        UserDTO user = userService.getUser((String) session.getAttribute("user"));
        session.setAttribute("fullName", user.getName()+" "+user.getPatronymic());
        List<CurrencyKursDTO> currencyKursDTOList = operationService.getCurrency();
        model.addAttribute("currencyList", currencyKursDTOList);
        return "user/main";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String createNewDeposit(HttpSession session) {
        return "user/deposit";
    }
}
