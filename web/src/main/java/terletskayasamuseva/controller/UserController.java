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
import terletskayasamuseva.model.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    private final UserService userService;
    private final OperationService operationService;
    private final DepositService depositService;
    private final PaymentService paymentService;
    private final AccountService accountService;

    @Autowired
    public UserController(UserService userService,
                          OperationService operationService,
                          DepositService depositService,
                          PaymentService paymentService,
                          AccountService accountService) {
        this.userService = userService;
        this.operationService = operationService;
        this.depositService = depositService;
        this.paymentService = paymentService;
        this.accountService = accountService;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String openUserMainPage(HttpSession session, Model model) {
        UserDTO user = userService.getUser((String) session.getAttribute("user"));
        session.setAttribute("fullName", user.getName() + " " + user.getPatronymic());
        List<CurrencyKursDTO> currencyKursDTOList = operationService.getCurrency();
        model.addAttribute("currencyList", currencyKursDTOList);
        return "user/main";
    }

    //DepositOperation with account

    @RequestMapping(value = "/account/new", method = RequestMethod.GET)
    public String openUserAccountNew() {
        return "user/openAccount";
    }

    @RequestMapping(value = "/account/new", method = RequestMethod.POST)
    public String createNewAccount(HttpSession session, @RequestParam("currency") String currency){
        AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
        accountRequestDTO.setType("CURRENT");
        accountRequestDTO.setCurrency(currency);
        accountService.addAccountRequest(accountRequestDTO, (String) session.getAttribute("user"));
        return "user/openAccount";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String openUserAccount() {
        return "user/openAccount";   //change
    }

    //DepositOperation with deposit

    @RequestMapping(value = "/deposit/choose", method = RequestMethod.GET)
    public String openChooseDeposit() {
        return "user/chooseDeposit";
    }

    @RequestMapping(value = "/deposit/choose", method = RequestMethod.POST)
    public String chooseDeposit(Model model, @ModelAttribute DepositDTO depositDTO) {
        List<DepositDTO> deposits = depositService.getDepositsByParameter(depositDTO);
        return "user/chooseDeposit";     //change
    }

    @RequestMapping(value = "/deposit/new", method = RequestMethod.GET)
    public String openCreateDeposit() {
        return "user/openDeposit";
    }

    @RequestMapping(value = "/deposit/new", method = RequestMethod.POST)
    public String createDeposit(HttpSession session, @RequestParam("telephone") String telephone) {
        AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
        accountRequestDTO.setTelephone(telephone);
        accountRequestDTO.setType("DEPOSIT");
        accountService.addAccountRequest(accountRequestDTO, (String) session.getAttribute("user"));
        return "user/openDeposit";
    }

    @RequestMapping(value = "/deposit/plus", method = RequestMethod.GET)
    public String openRepayDepositForUser() {
        return "user/plusDeposit";
    }

    //DepositOperation with loans

    @RequestMapping(value = "/loans/new", method = RequestMethod.GET)
    public String openCreateNewLoan() {
        return "user/openLoans";
    }

    @RequestMapping(value = "/loans/new", method = RequestMethod.POST)
    public String createNewLoan(HttpSession session, @RequestParam("telephone") String telephone) {
        AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
        accountRequestDTO.setTelephone(telephone);
        accountRequestDTO.setType("CREDIT");
        accountService.addAccountRequest(accountRequestDTO, (String) session.getAttribute("user"));
        return "user/openLoans";
    }

    @RequestMapping(value = "/loans/repay", method = RequestMethod.GET)
    public String openRepayLoansForUser() {
        return "user/repayLoans";
    }

    //DepositOperation with transaction

    @RequestMapping(value = "/transaction/my", method = RequestMethod.GET)
    public String openTransactionMyAccount() {
        return "user/transactionMyAccount";
    }

    @RequestMapping(value = "/transaction/currency", method = RequestMethod.GET)
    public String openChangeCurrency() {
        return "user/changeCurrency";
    }

    @RequestMapping(value = "/transaction/other", method = RequestMethod.GET)
    public String openTransactionOtherClient() {
        return "user/transactionOtherClient";
    }

    @RequestMapping(value = "/transaction/history", method = RequestMethod.GET)
    public String openTransactionHistory() {
        return "user/transactionHistory";
    }

    //Operations with payments
    @RequestMapping(value = "/payment/ERIP", method = RequestMethod.GET)
    public String openPaymentERIP(Model model) {
        List<PaymentDTO> payments = paymentService.getAll();
        model.addAttribute("payments", payments);
        return "user/paymentsERIP";
    }

    @RequestMapping(value = "/payment/history", method = RequestMethod.GET)
    public String openPaymentHistory() {
        return "user/paymentHistory";
    }

    //Operations with setting

    @RequestMapping(value = "/change/login", method = RequestMethod.GET)
    public String openChangeLogin() {
        return "user/changeLogin";
    }

    @RequestMapping(value = "/change/login", method = RequestMethod.POST)
    public String changeUserLogin(HttpSession session, Model model,
                                  @RequestParam("currentLogin") String currentLogin,
                                  @RequestParam("newLogin") String newLogin,
                                  @RequestParam("proofLogin") String proofLogin) {
        String username = (String) session.getAttribute("user");
        if ( username.equals(currentLogin) ) {
            if ( newLogin.equals(proofLogin) ) {
                if ( userService.getUserByEmail(newLogin) == null ) {
                    userService.updateUsername(username, newLogin);
                    session.setAttribute("user", newLogin);
                } else
                    model.addAttribute("errorNewLogin", "*Логин занят");
            } else
                model.addAttribute("errorProofLogin", "*Логины не совпадают");
        } else
            model.addAttribute("errorCurrentLogin", "*Неверный текущий логин");
        return "user/changeLogin";
    }

    @RequestMapping(value = "/change/password", method = RequestMethod.GET)
    public String openChangePassword() {
        return "user/changePassword";
    }

    @RequestMapping(value = "/change/password", method = RequestMethod.POST)
    public String changePassword(HttpSession session, Model model,
                                 @RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("proofPassword") String proofPassword) {
        String username = (String) session.getAttribute("user");
        if ( userService.findUser(username, currentPassword) ) {
            if ( newPassword.equals(proofPassword) )
                userService.updatePassword(username, newPassword);
            else
                model.addAttribute("errorNewPassword", "*Пароли не совпадают");
        } else {
            model.addAttribute("errorCurrentPassword", "*Неверный текущий пароль");
        }
        return "user/changePassword";
    }
}
