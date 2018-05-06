package terletskayasamuseva.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import terletskayasamuseva.DepositService;
import terletskayasamuseva.OperationService;
import terletskayasamuseva.PaymentService;
import terletskayasamuseva.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private static final Logger logger = Logger.getLogger(AdminController.class);

    private final UserService userService;
    private final OperationService operationService;
    private final DepositService depositService;
    private final PaymentService paymentService;

    @Autowired
    public AdminController(UserService userService,
                           OperationService operationService,
                           DepositService depositService,
                           PaymentService paymentService) {
        this.userService = userService;
        this.operationService = operationService;
        this.depositService = depositService;
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String openAdminMainPage() {
        return "admin/mainAdmin";
    }

    //Operation with deposit

    @RequestMapping(value = "/deposit/new", method = RequestMethod.GET)
    public String openAddNewDeposit() {
        return "admin/addDeposit";
    }

    @RequestMapping(value = "/deposit/open", method = RequestMethod.GET)
    public String openOpenDeposit() {
        return "admin/openDeposit";
    }

    @RequestMapping(value = "/deposit/view", method = RequestMethod.GET)
    public String openViewDeposit() {
        return "admin/viewDeposit";
    }

    //Operation with loans

    @RequestMapping(value = "/loan/new", method = RequestMethod.GET)
    public String openAddNewLoan() {
        return "admin/addLoan";
    }

    @RequestMapping(value = "/loan/open", method = RequestMethod.GET)
    public String openOpenLoan() {
        return "admin/openLoan";
    }

    @RequestMapping(value = "/loan/view", method = RequestMethod.GET)
    public String openViewLoan() {
        return "admin/viewLoan";
    }

    //Operation with account

    @RequestMapping(value = "/account/open", method = RequestMethod.GET)
    public String openCreateAccount() {
        return "admin/openAccount";
    }

    @RequestMapping(value = "/account/plus", method = RequestMethod.GET)
    public String openPlusAccount() {
        return "admin/plusAccount";
    }

    @RequestMapping(value = "/account/request", method = RequestMethod.GET)
    public String openAccountRequest() {
        return "admin/openCurrentAccount";
    }

    //Operation with transaction

    @RequestMapping(value = "/kurs", method = RequestMethod.GET)
    public String openChangeKurs() {
        return "admin/changeKurs";
    }

    //Operation with users

    @RequestMapping(value = "/user/show", method = RequestMethod.GET)
    public String openShowUsers() {
        return "admin/showUsers";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String openRegistrationUser() {
        return "admin/registrationUser";
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    public String openSearchUser() {
        return "admin/searchUser";
    }
}
