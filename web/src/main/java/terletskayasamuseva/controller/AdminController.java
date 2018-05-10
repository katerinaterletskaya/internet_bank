package terletskayasamuseva.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import terletskayasamuseva.*;
import terletskayasamuseva.model.*;
import terletskayasamuseva.validator.UserValidator;

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
    public String addNewDeposit(@ModelAttribute DepositDTO depositDTO,
                                @RequestParam("isReversal") String isReversal,
                                Model model) {
        Boolean reversal = Boolean.parseBoolean(isReversal);
        depositDTO.setReversal(reversal);
        if ( !depositService.getDepositByName(depositDTO.getName()) ) {
            if ( depositService.addDeposit(depositDTO) )
                return "redirect:/admin/main";
            else
                return "admin/addDeposit";
        } else {
            model.addAttribute("error", "Депозит с таким названием уже существует!");
            return "admin/addDeposit";
        }
    }

    @RequestMapping(value = "/deposit/open", method = RequestMethod.GET)
    public String openOpenDeposit(Model model) {
        List<DepositDTO> depositList = depositService.getAll();
        model.addAttribute("deposits", depositList);
        return "admin/openDeposit";
    }

    @RequestMapping(value = "/deposit/open", method = RequestMethod.POST)
    public String openDeposit(@ModelAttribute DepositDTO depositDTO,
                              @RequestParam("passport") String passport) {
        if ( userService.findUserByPassport(passport) ) {
            logger.info(depositDTO.toString());
            depositService.addDepositForUser(passport, depositDTO.getCurrency(), depositDTO.getMinSum());
            return "redirect:/admin/main";
        } else
            return "redirect:/admin/user/new";
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
        return "admin/viewDeposit";
    }


    //DepositOperation with loans

    @RequestMapping(value = "/loan/new", method = RequestMethod.GET)
    public String openAddNewLoan() {
        return "admin/addLoan";
    }

    @RequestMapping(value = "/loan/new", method = RequestMethod.POST)
    public String addNewLoan(@ModelAttribute CreditDTO creditDTO,
                             Model model) {
        if ( !creditService.findCreditByName(creditDTO.getName()) ) {
            if ( creditService.addCredit(creditDTO) )
                return "redirect:/admin/main";
            else
                return "admin/addLoan";
        } else {
            model.addAttribute("error", "Кредит с таким названием уже существует!");
            return "admin/addLoan";
        }
    }

    @RequestMapping(value = "/loan/open", method = RequestMethod.GET)
    public String openOpenLoan(Model model) {
        List<CreditDTO> creditList = creditService.getAll();
        model.addAttribute("credits", creditList);
        return "admin/openLoan";
    }

    @RequestMapping(value = "/loan/open", method = RequestMethod.POST)
    public String openLoan(@ModelAttribute CreditDTO creditDTO,
                           @RequestParam("passport") String passport) {
        if ( userService.findUserByPassport(passport) ) {
            creditService.addCreditForUser(passport, creditDTO.getCurrency(), creditDTO.getMinSum());
            return "redirect:/admin/main";
        } else
            return "redirect:/admin/user/new";
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


    //Operation with account

    @RequestMapping(value = "/account/open", method = RequestMethod.GET)
    public String openCreateAccount() {
        return "admin/openAccount";
    }

    @RequestMapping(value = "/account/open", method = RequestMethod.POST)
    public String createAccount(@RequestParam("passport") String passport,
                                @RequestParam("currency") String currency,
                                @RequestParam("sum") BigDecimal sum) {
        logger.info(passport);
        logger.info(currency);
        logger.info(sum);
        if ( userService.findUserByPassport(passport) ) {
            accountService.addCurrentAccountForUser(passport, currency, sum);
            return "redirect:/admin/main";
        } else
            return "redirect:/admin/user/new";
    }


    @RequestMapping(value = "/account/plus", method = RequestMethod.GET)
    public String openPlusAccount() {
        return "admin/plusAccount";
    }

    @RequestMapping(value = "/account/plus", method = RequestMethod.POST)
    public String findNumberAccount(Model model,
                                    @RequestParam("passport") String passport) {
        if ( userService.findUserByPassport(passport) ) {
            List<String> numbers = accountService.getNumberAccountForUser(passport);
            if ( numbers.size() == 0 )
                model.addAttribute("info", "У данного пользователя нет текущих счетов!");
            else
                model.addAttribute("numbers", numbers);
        } else
            model.addAttribute("error", "Пользователь не найден!");
        return "admin/plusAccount";
    }

    @RequestMapping(value = "/account/plus/sum", method = RequestMethod.POST)
    public String addSumToAccount(@RequestParam("accountNumber") String number,
                                  @RequestParam("minSum") BigDecimal sum) {
        AccountDTO account = accountService.getCurrentAccountByNumber(number);
        BigDecimal sum1 = account.getSum().add(sum);
        accountService.updateSum(account.getNumber(), sum1);
        return "redirect:/admin/main";
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
    public String openChangeKurs(Model model) {
        List<CurrencyKursDTO> currencyList = operationService.getCurrency();
        model.addAttribute("currencies", currencyList);
        return "admin/changeKurs";
    }

    @RequestMapping(value = "/kurs", method = RequestMethod.POST)
    public String changeKurs(@RequestParam("costUSD") BigDecimal costUSD,
                             @RequestParam("saleUSD") BigDecimal saleUSD,
                             @RequestParam("costEUR") BigDecimal costEUR,
                             @RequestParam("saleEUR") BigDecimal saleEUR,
                             @RequestParam("costRUB") BigDecimal costRUB,
                             @RequestParam("saleRUB") BigDecimal saleRUB) {
        operationService.changeCurrency("USD", costUSD, saleUSD);
        operationService.changeCurrency("EUR", costEUR, saleEUR);
        operationService.changeCurrency("RUB", costRUB, saleRUB);
        return "redirect:/admin/kurs";
    }

    //DepositOperation with users

    @RequestMapping(value = "/user/show", method = RequestMethod.GET)
    public String openShowUsers(Model model) {
        List<UserDTO> users = userService.getAllUserForAdmin();
        for (UserDTO user : users) {
            user.setNumberAccount(accountService.getNumberAccountForUser(user.getUsername(), "CURRENT"));
            user.setNumberCredit(accountService.getNumberAccountForUser(user.getUsername(), "CREDIT"));
            user.setNumberDeposit(accountService.getNumberAccountForUser(user.getUsername(), "DEPOSIT"));
        }
        model.addAttribute("users", users);
        return "admin/showUsers";
    }

    @RequestMapping(value = "/user/show", method = RequestMethod.POST)
    public String changeUserStatus(@RequestParam("username") String username,
                                   @RequestParam("status") String status) {
        userService.updateStatus(username, status);
        return "redirect:/admin/user/show";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String openRegistrationUser() {
        return "admin/registrationUser";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public String registrationUser(@ModelAttribute UserDTO user, Model model) {
        if ( userService.getUserByEmail(user.getUsername()) != null ) {
            model.addAttribute("usernameError", "Пользователь с таким адресом уже существует!");
        } else {
            userService.save(user);
        }
        return "admin/registrationUser";
    }
}
