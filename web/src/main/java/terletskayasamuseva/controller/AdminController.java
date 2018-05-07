package terletskayasamuseva.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import terletskayasamuseva.*;
import terletskayasamuseva.model.AccountRequestDTO;
import terletskayasamuseva.model.UserDTO;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private static final Logger logger = Logger.getLogger(AdminController.class);

    private final UserService userService;
    private final OperationService operationService;
    private final DepositService depositService;
    private final PaymentService paymentService;
    private final AccountService accountService;
    private final CreditService creditService;

    @Autowired
    public AdminController(UserService userService,
                           OperationService operationService,
                           DepositService depositService,
                           PaymentService paymentService,
                           AccountService accountService,
                           CreditService creditService) {
        this.userService = userService;
        this.operationService = operationService;
        this.depositService = depositService;
        this.paymentService = paymentService;
        this.accountService = accountService;
        this.creditService = creditService;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String openAdminMainPage() {
        return "admin/mainAdmin";
    }

    //DepositOperation with deposit

    @RequestMapping(value = "/deposit/new", method = RequestMethod.GET)
    public String openAddNewDeposit() {
        return "admin/addDeposit";
    }

    @RequestMapping(value = "/deposit/new", method = RequestMethod.POST)
    public String addNewDeposit() {

        return "admin/addDeposit";
    }

    @RequestMapping(value = "/deposit/open", method = RequestMethod.GET)
    public String openOpenDeposit() {
        return "admin/openDeposit";
    }

    @RequestMapping(value = "/deposit/request", method = RequestMethod.GET)
    public String openViewDeposit(Model model) {
        List<AccountRequestDTO> deposits = depositService.getRequestForDeposit();
        model.addAttribute("deposits", deposits);
        return "admin/viewDeposit";
    }

    @RequestMapping(value = "/deposit/request", method = RequestMethod.POST)
    public String requestForDeposit(@ModelAttribute AccountRequestDTO accountRequest) {
        accountRequest.setType("DEPOSIT");
        depositService.updateRequestForDeposit(accountRequest);
        return "redirect:/admin/deposit/request";
    }

    //DepositOperation with loans

    @RequestMapping(value = "/loan/new", method = RequestMethod.GET)
    public String openAddNewLoan() {
        return "admin/addLoan";
    }

    @RequestMapping(value = "/loan/open", method = RequestMethod.GET)
    public String openOpenLoan() {
        return "admin/openLoan";
    }

    @RequestMapping(value = "/loan/request", method = RequestMethod.GET)
    public String openViewLoan(Model model) {
        List<AccountRequestDTO> requestsForCredit = creditService.getRequestForCredit();
        model.addAttribute("credits", requestsForCredit);
        return "admin/viewLoan";
    }

    @RequestMapping(value = "/loan/request", method = RequestMethod.POST)
    public String requestForLoan(@ModelAttribute AccountRequestDTO accountRequest) {
        accountRequest.setType("CREDIT");
        creditService.changeCreditRequestStatus(accountRequest);
        return "redirect:/admin/loan/request";
    }

    //DepositOperation with account

    @RequestMapping(value = "/account/open", method = RequestMethod.GET)
    public String openCreateAccount() {
        return "admin/openAccount";
    }

    @RequestMapping(value = "/account/open", method = RequestMethod.POST)
    public String createAccount() {
        return "admin/openAccount";
    }

    @RequestMapping(value = "/account/plus", method = RequestMethod.GET)
    public String openPlusAccount() {
        return "admin/plusAccount";
    }

    @RequestMapping(value = "/account/request", method = RequestMethod.GET)
    public String openAccountRequest(Model model) {
        List<AccountRequestDTO> requestList = accountService.getAccountRequest();
        model.addAttribute("requestList", requestList);
        return "admin/openCurrentAccount";
    }

    @RequestMapping(value = "/account/request", method = RequestMethod.POST)
    public String RequestForAccount(@ModelAttribute AccountRequestDTO accountRequest,
                                    @RequestParam("passport") String passport) {
        accountRequest.setType("CURRENT");
        accountService.changeAccountRequestStatus(accountRequest);
        accountService.addCurrentAccountForUser(passport, accountRequest.getCurrency(), new BigDecimal((0.0)));
        return "redirect:/admin/account/request";
    }

    //DepositOperation with transaction

    @RequestMapping(value = "/kurs", method = RequestMethod.GET)
    public String openChangeKurs() {
        return "admin/changeKurs";
    }

    //DepositOperation with users

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
