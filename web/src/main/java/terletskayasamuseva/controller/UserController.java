package terletskayasamuseva.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import terletskayasamuseva.*;
import terletskayasamuseva.model.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
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
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        List<AccountDTO> deposits = accountService.getAccountForUser((String) session.getAttribute("user"), "DEPOSIT");
        List<AccountDTO> credits = accountService.getAccountForUser((String) session.getAttribute("user"), "CREDIT");
        UserDTO user = userService.getUser((String) session.getAttribute("user"));
        session.setAttribute("fullName", user.getName() + " " + user.getPatronymic());
        List<CurrencyKursDTO> currencyKursDTOList = operationService.getCurrency();
        model.addAttribute("currencyList", currencyKursDTOList);
        model.addAttribute("accounts", accounts);
        model.addAttribute("deposits", deposits);
        model.addAttribute("credits", credits);
        return "user/main";
    }

    //DepositOperation with account

    @RequestMapping(value = "/account/new", method = RequestMethod.GET)
    public String openUserAccountNew() {
        return "user/openAccount";
    }

    @RequestMapping(value = "/account/new", method = RequestMethod.POST)
    public String createNewAccount(HttpSession session, @RequestParam("currency") String currency) {
        AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
        accountRequestDTO.setType("CURRENT");
        accountRequestDTO.setCurrency(currency);
        accountService.addAccountRequest(accountRequestDTO, (String) session.getAttribute("user"));
        return "redirect:/user/main";
    }


    //DepositOperation with deposit

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
        return "redirect:/user/main";
    }

    @RequestMapping(value = "/deposit/plus", method = RequestMethod.GET)
    public String openRepayDepositForUser(HttpSession session, Model model) {
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        List<AccountDTO> deposits = accountService.getAccountForUser((String) session.getAttribute("user"), "DEPOSIT");
        model.addAttribute("accounts", accounts);
        model.addAttribute("deposits", deposits);
        return "user/plusDeposit";
    }

    @RequestMapping(value = "/deposit/plus", method = RequestMethod.POST)
    public String repayDepositForUser(Model model, HttpSession session,
                                      @RequestParam("fromAccount") String fromAccount,
                                      @RequestParam("toAccount") String toAccount,
                                      @RequestParam("transactionSumma") BigDecimal sum,
                                      @RequestParam("sumFrom") BigDecimal sumFrom) {
        UserDTO user = userService.getUserByEmail((String) session.getAttribute("user"));
        AccountDTO accountFrom = accountService.getCurrentAccountByNumber(fromAccount);
        AccountDTO accountTo = accountService.getCurrentAccountByNumber(toAccount);
        if ( accountFrom.getCurrency().equals(accountTo.getCurrency()) ) {
            if ( accountFrom.getSum().compareTo(sumFrom) == 1 || accountFrom.getSum().compareTo(sumFrom) == 0 ) {
                BigDecimal sum1 = accountTo.getSum().add(sum);
                accountService.updateSum(accountTo.getNumber(), sum1);
                BigDecimal sum2 = accountFrom.getSum().subtract(sumFrom);
                accountService.updateSum(accountFrom.getNumber(), sum2);
                TransactionDTO transactionDTO = new TransactionDTO(accountFrom.getCurrency(), sumFrom, toAccount, user.getSurname());
                operationService.addTransaction(transactionDTO, fromAccount);
                return "redirect:/user/main";
            } else {
                model.addAttribute("error", "На счете недостаточно средств!");
            }
        } else {
            model.addAttribute("error", "Валюта выбранных счетов не совпадает!");
        }
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        List<AccountDTO> deposits = accountService.getAccountForUser((String) session.getAttribute("user"), "DEPOSIT");
        model.addAttribute("accounts", accounts);
        model.addAttribute("deposits", deposits);
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
    public String openRepayLoansForUser(HttpSession session, Model model) {
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        List<AccountDTO> credits = accountService.getAccountForUser((String) session.getAttribute("user"), "CREDIT");
        model.addAttribute("accounts", accounts);
        model.addAttribute("credits", credits);
        return "user/repayLoans";
    }

    @RequestMapping(value = "/loans/repay", method = RequestMethod.POST)
    public String repayLoansForUser(Model model, HttpSession session,
                                    @RequestParam("fromAccount") String fromAccount,
                                    @RequestParam("toAccount") String toAccount,
                                    @RequestParam("transactionSumma") BigDecimal sum,
                                    @RequestParam("sumFrom") BigDecimal sumFrom) {
        UserDTO user = userService.getUserByEmail((String) session.getAttribute("user"));
        AccountDTO accountFrom = accountService.getCurrentAccountByNumber(fromAccount);
        AccountDTO accountTo = accountService.getCurrentAccountByNumber(toAccount);
        if ( accountFrom.getCurrency().equals(accountTo.getCurrency()) ) {
            if ( accountFrom.getSum().compareTo(sumFrom) == 1 || accountFrom.getSum().compareTo(sumFrom) == 0 ) {
                BigDecimal sum1 = accountTo.getSum().subtract(sum);
                accountService.updateSum(accountTo.getNumber(), sum1);
                BigDecimal sum2 = accountFrom.getSum().subtract(sumFrom);
                accountService.updateSum(accountFrom.getNumber(), sum2);
                TransactionDTO transactionDTO = new TransactionDTO(accountFrom.getCurrency(), sumFrom, toAccount, user.getSurname());
                operationService.addTransaction(transactionDTO, fromAccount);
                return "redirect:/user/main";
            } else {
                model.addAttribute("error", "На счете недостаточно средств!");
            }
        } else {
            model.addAttribute("error", "Валюта выбранных счетов не совпадает!");
        }
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        List<AccountDTO> credits = accountService.getAccountForUser((String) session.getAttribute("user"), "CREDIT");
        model.addAttribute("accounts", accounts);
        model.addAttribute("credits", credits);
        return "user/repayLoans";
    }

    //Chart

    @RequestMapping(value = "/diagram/line", method = RequestMethod.GET)
    public String openLineDiagram(Model model, HttpSession session) {
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("numbers", numbers);
        return "diagrams/lineDiagram";
    }

    @RequestMapping(value = "/diagram/line", method = RequestMethod.POST)
    public String createLineDiagram(Model model, HttpSession session,
                                    @RequestParam("number") String number) {
        List<String> categories = new ArrayList<>();
        List<BigDecimal> sums = new ArrayList<>();
        for (OperationDTO operationDTO : operationService.getOperations(number)) {
            categories.add(operationDTO.getPaymentCategory());
            sums.add(operationDTO.getSum());
        }
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("categories", categories);
        model.addAttribute("sums", sums);
        model.addAttribute("numbers", numbers);
        return "diagrams/lineDiagram";
    }

    @RequestMapping(value = "/diagram/chart", method = RequestMethod.GET)
    public String openChartDiagram(Model model, HttpSession session) {
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("numbers", numbers);
        return "diagrams/chartDiagram";
    }

    @RequestMapping(value = "/diagram/chart", method = RequestMethod.POST)
    public String createChartDiagram(Model model, HttpSession session,
                                     @RequestParam("number") String number) {
        List<String> categories = new ArrayList<>();
        List<BigDecimal> sums = new ArrayList<>();
        for (OperationDTO operationDTO : operationService.getOperations(number)) {
            categories.add(operationDTO.getPaymentCategory());
            sums.add(operationDTO.getSum());
        }
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("categories", categories);
        model.addAttribute("sums", sums);
        model.addAttribute("numbers", numbers);
        return "diagrams/chartDiagram";
    }

    //DepositOperation with transaction

    @RequestMapping(value = "/transaction/my", method = RequestMethod.GET)
    public String openTransactionMyAccount(HttpSession session, Model model) {
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        model.addAttribute("accounts", accounts);
        return "user/transactionMyAccount";
    }

    @RequestMapping(value = "/transaction/my", method = RequestMethod.POST)
    public String transactionMyAccount(Model model, HttpSession session,
                                       @RequestParam("fromAccount") String fromAccount,
                                       @RequestParam("toAccount") String toAccount,
                                       @RequestParam("transactionSumma") BigDecimal sum,
                                       @RequestParam("sumFrom") BigDecimal sumFrom) {
        UserDTO user = userService.getUserByEmail((String) session.getAttribute("user"));
        AccountDTO accountFrom = accountService.getCurrentAccountByNumber(fromAccount);
        AccountDTO accountTo = accountService.getCurrentAccountByNumber(toAccount);
        if ( !accountFrom.getNumber().equals(accountTo.getNumber()) ) {
            if ( accountFrom.getCurrency().equals(accountTo.getCurrency()) ) {
                if ( accountFrom.getSum().compareTo(sumFrom) == 1 || accountFrom.getSum().compareTo(sumFrom) == 0 ) {
                    BigDecimal sum1 = accountTo.getSum().add(sum);
                    accountService.updateSum(accountTo.getNumber(), sum1);
                    BigDecimal sum2 = accountFrom.getSum().subtract(sumFrom);
                    accountService.updateSum(accountFrom.getNumber(), sum2);
                    TransactionDTO transactionDTO = new TransactionDTO(accountFrom.getCurrency(), sumFrom, toAccount, user.getSurname());
                    operationService.addTransaction(transactionDTO, fromAccount);
                    return "redirect:/user/main";
                } else {
                    model.addAttribute("error", "На счете недостаточно средств!");
                }
            } else {
                model.addAttribute("error", "Валюта выбранных счетов не совпадает!");
            }
            List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
            model.addAttribute("accounts", accounts);
            return "user/transactionMyAccount";
        } else
            return "redirect:/user/main";
    }

    @RequestMapping(value = "/transaction/other", method = RequestMethod.GET)
    public String openTransactionOtherClient(Model model, HttpSession session) {
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        model.addAttribute("accounts", accounts);
        return "user/transactionOtherClient";
    }

    @RequestMapping(value = "/transaction/other", method = RequestMethod.POST)
    public String transactionOtherClient(HttpSession session, Model model,
                                         @RequestParam("fromAccount") String fromAccount,
                                         @RequestParam("toAccount") String toAccount,
                                         @RequestParam("surname") String surname,
                                         @RequestParam("sumFrom") BigDecimal sumFrom) {
        AccountDTO accountFrom = accountService.getCurrentAccountByNumber(fromAccount);
        if ( accountFrom.getSum().compareTo(sumFrom) == 1 || accountFrom.getSum().compareTo(sumFrom) == 0 ) {
            BigDecimal sum = accountFrom.getSum().subtract(sumFrom);
            accountService.updateSum(accountFrom.getNumber(), sum);
            TransactionDTO transactionDTO = new TransactionDTO(accountFrom.getCurrency(), sumFrom, toAccount, surname);
            operationService.addTransaction(transactionDTO, fromAccount);
            return "redirect:/user/main";
        } else
            model.addAttribute("error", "На счете недостаточно средств!");
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        model.addAttribute("accounts", accounts);
        return "user/transactionOtherClient";
    }

    @RequestMapping(value = "/transaction/history", method = RequestMethod.GET)
    public String openTransactionHistory(Model model, HttpSession session) {
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        model.addAttribute("accounts", accounts);
        return "user/transactionHistory";
    }

    @RequestMapping(value = "/transaction/history", method = RequestMethod.POST)
    public String openTransactionHistory(Model model, HttpSession session,
                                         @RequestParam("accountNumber") String accountNumber,
                                         @RequestParam("day") String day,
                                         @RequestParam("dateFrom") String dateFrom,
                                         @RequestParam("dateTo") String dateTo) {

        List<TransactionDTO> transactions = operationService.getTransactionsWithParameter(accountNumber, dateFrom, dateTo, day);
        model.addAttribute("transactions", transactions);
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        model.addAttribute("accounts", accounts);
        return "user/transactionHistory";
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
                    return "redirect:/user/main";
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
            if ( newPassword.equals(proofPassword) ) {
                userService.updatePassword(username, newPassword);
                return "redirect:/user/main";
            } else
                model.addAttribute("errorNewPassword", "*Пароли не совпадают");
        } else {
            model.addAttribute("errorCurrentPassword", "*Неверный текущий пароль");
        }
        return "user/changePassword";
    }


    //Operation with payments

    @RequestMapping(value = "/payment/ERIP", method = RequestMethod.GET)
    public String openPaymentERIP(Model model) {
        List<PaymentDTO> payments = paymentService.getAll();
        model.addAttribute("payments", payments);
        return "user/paymentsERIP";
    }

    @RequestMapping(value = "/payment/history", method = RequestMethod.GET)
    public String openPaymentHistory(HttpSession session, Model model) {
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        model.addAttribute("accounts", accounts);
        return "user/paymentHistory";
    }

    @RequestMapping(value = "/payment/history", method = RequestMethod.POST)
    public String paymentHistory(HttpSession session, Model model,
                                 @RequestParam("accountNumber") String accountNumber,
                                 @RequestParam("day") String day,
                                 @RequestParam("dateFrom") String dateFrom,
                                 @RequestParam("dateTo") String dateTo) {

        List<OperationDTO> operations = operationService.getOperationsWithParameter(accountNumber, dateFrom, dateTo, day);
        model.addAttribute("operations", operations);
        List<AccountDTO> accounts = accountService.getAccountForUser((String) session.getAttribute("user"), "CURRENT");
        model.addAttribute("accounts", accounts);
        return "user/paymentHistory";
    }

    @RequestMapping(value = "/payment/ERIP/ticket/{id}", method = RequestMethod.GET)
    public String openFirstCategory(@PathVariable Long id, HttpSession session, Model model) {
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("numbers", numbers);
        model.addAttribute("id", id);
        return "payments/firstCategory";
    }

    @RequestMapping(value = "/payment/ERIP/ticket", method = RequestMethod.POST)
    public String addFirstCategory(@ModelAttribute OperationDTO operationDTO,
                                   Model model, HttpSession session) {
        AccountDTO account = accountService.getCurrentAccountByNumber(operationDTO.getAccount());
        int flag = account.getSum().compareTo(operationDTO.getSum());
        if ( flag == 1 || flag == 0 ) {
            BigDecimal sum = account.getSum().subtract(operationDTO.getSum());
            accountService.updateSum(account.getNumber(), sum);
            operationDTO.setCurrency(account.getCurrency());
            operationService.addNewOperation(operationDTO);
            return "redirect:/user/main";
        } else {
            model.addAttribute("error", "На вашем счете недостаточно средств");
            List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
            model.addAttribute("numbers", numbers);
            model.addAttribute("id", operationDTO.getPayment());
            return "payments/firstCategory";
        }
    }

    @RequestMapping(value = "/payment/ERIP/internet/{id}", method = RequestMethod.GET)
    public String openSecondCategory(@PathVariable Long id, HttpSession session, Model model) {
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("numbers", numbers);
        model.addAttribute("id", id);
        return "payments/secondCategory";
    }

    @RequestMapping(value = "/payment/ERIP/internet", method = RequestMethod.POST)
    public String addSecondCategory(@ModelAttribute OperationDTO operationDTO,
                                    Model model, HttpSession session) {
        logger.info(operationDTO.toString());
        AccountDTO account = accountService.getCurrentAccountByNumber(operationDTO.getAccount());
        int flag = account.getSum().compareTo(operationDTO.getSum());
        if ( flag == 1 || flag == 0 ) {
            BigDecimal sum = account.getSum().subtract(operationDTO.getSum());
            accountService.updateSum(account.getNumber(), sum);
            operationDTO.setCurrency(account.getCurrency());
            operationService.addNewOperation(operationDTO);
            return "redirect:/user/main";
        } else {
            model.addAttribute("error", "На вашем счете недостаточно средств");
            List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
            model.addAttribute("numbers", numbers);
            model.addAttribute("id", operationDTO.getPayment());
            return "payments/secondCategory";
        }
    }

    @RequestMapping(value = "/payment/ERIP/shop/{id}", method = RequestMethod.GET)
    public String openThirdCategory(@PathVariable Long id, HttpSession session, Model model) {
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("numbers", numbers);
        return "payments/thirdCategory";
    }

    @RequestMapping(value = "/payment/ERIP/shop", method = RequestMethod.POST)
    public String addThirdCategory(@ModelAttribute OperationDTO operationDTO,
                                   Model model, HttpSession session) {
        AccountDTO account = accountService.getCurrentAccountByNumber(operationDTO.getAccount());
        int flag = account.getSum().compareTo(operationDTO.getSum());
        if ( flag == 1 || flag == 0 ) {
            BigDecimal sum = account.getSum().subtract(operationDTO.getSum());
            accountService.updateSum(account.getNumber(), sum);
            operationDTO.setCurrency(account.getCurrency());
            operationService.addNewOperation(operationDTO);
            return "redirect:/user/main";
        } else {
            model.addAttribute("error", "На вашем счете недостаточно средств");
            List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
            model.addAttribute("numbers", numbers);
            model.addAttribute("id", operationDTO.getPayment());
            return "payments/thirdCategory";
        }
    }

    @RequestMapping(value = "/payment/ERIP/mia/{id}", method = RequestMethod.GET)
    public String openForthCategory(@PathVariable Long id, HttpSession session, Model model) {
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("numbers", numbers);
        return "payments/forthCategory";
    }

    @RequestMapping(value = "/payment/ERIP/mia", method = RequestMethod.POST)
    public String openForthCategory(@ModelAttribute OperationDTO operationDTO,
                                    Model model, HttpSession session) {
        AccountDTO account = accountService.getCurrentAccountByNumber(operationDTO.getAccount());
        int flag = account.getSum().compareTo(operationDTO.getSum());
        if ( flag == 1 || flag == 0 ) {
            BigDecimal sum = account.getSum().subtract(operationDTO.getSum());
            accountService.updateSum(account.getNumber(), sum);
            operationDTO.setCurrency(account.getCurrency());
            operationService.addNewOperation(operationDTO);
            return "redirect:/user/main";
        } else {
            model.addAttribute("error", "На вашем счете недостаточно средств");
            List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
            model.addAttribute("numbers", numbers);
            model.addAttribute("id", operationDTO.getPayment());
            return "payments/forthCategory";
        }
    }

    @RequestMapping(value = "/payment/ERIP/mobile/{id}", method = RequestMethod.GET)
    public String openFivesCategory(@PathVariable Long id, HttpSession session, Model model) {
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("numbers", numbers);
        return "payments/fivesCategory";
    }

    @RequestMapping(value = "/payment/ERIP/mobile", method = RequestMethod.POST)
    public String addFivesCategory(@ModelAttribute OperationDTO operationDTO,
                                   Model model, HttpSession session) {
        AccountDTO account = accountService.getCurrentAccountByNumber(operationDTO.getAccount());
        int flag = account.getSum().compareTo(operationDTO.getSum());
        if ( flag == 1 || flag == 0 ) {
            BigDecimal sum = account.getSum().subtract(operationDTO.getSum());
            accountService.updateSum(account.getNumber(), sum);
            operationDTO.setCurrency(account.getCurrency());
            operationService.addNewOperation(operationDTO);
            return "redirect:/user/main";
        } else {
            model.addAttribute("error", "На вашем счете недостаточно средств");
            List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
            model.addAttribute("numbers", numbers);
            model.addAttribute("id", operationDTO.getPayment());
            return "payments/fivesCategory";
        }
    }

    @RequestMapping(value = "/payment/ERIP/massmedia/{id}", method = RequestMethod.GET)
    public String openSixthCategory(@PathVariable Long id, HttpSession session, Model model) {
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("numbers", numbers);
        return "payments/sixthCategory";
    }

    @RequestMapping(value = "/payment/ERIP/massmedia", method = RequestMethod.POST)
    public String addSixthCategory(@ModelAttribute OperationDTO operationDTO,
                                   Model model, HttpSession session) {
        AccountDTO account = accountService.getCurrentAccountByNumber(operationDTO.getAccount());
        int flag = account.getSum().compareTo(operationDTO.getSum());
        if ( flag == 1 || flag == 0 ) {
            BigDecimal sum = account.getSum().subtract(operationDTO.getSum());
            accountService.updateSum(account.getNumber(), sum);
            operationDTO.setCurrency(account.getCurrency());
            operationService.addNewOperation(operationDTO);
            return "redirect:/user/main";
        } else {
            model.addAttribute("error", "На вашем счете недостаточно средств");
            List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
            model.addAttribute("numbers", numbers);
            model.addAttribute("id", operationDTO.getPayment());
            return "payments/sixthCategory";
        }
    }

    @RequestMapping(value = "/payment/ERIP/custom/{id}", method = RequestMethod.GET)
    public String openSeventhCategory(@PathVariable Long id, HttpSession session, Model model) {
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("numbers", numbers);
        return "payments/seventhCategory";
    }

    @RequestMapping(value = "/payment/ERIP/custom", method = RequestMethod.POST)
    public String addSeventhCategory(@ModelAttribute OperationDTO operationDTO,
                                     Model model, HttpSession session) {
        AccountDTO account = accountService.getCurrentAccountByNumber(operationDTO.getAccount());
        int flag = account.getSum().compareTo(operationDTO.getSum());
        if ( flag == 1 || flag == 0 ) {
            BigDecimal sum = account.getSum().subtract(operationDTO.getSum());
            accountService.updateSum(account.getNumber(), sum);
            operationDTO.setCurrency(account.getCurrency());
            operationService.addNewOperation(operationDTO);
            return "redirect:/user/main";
        } else {
            model.addAttribute("error", "На вашем счете недостаточно средств");
            List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
            model.addAttribute("numbers", numbers);
            model.addAttribute("id", operationDTO.getPayment());
            return "payments/seventhCategory";
        }
    }

    @RequestMapping(value = "/payment/ERIP/legal/{id}", method = RequestMethod.GET)
    public String openEighthCategory(@PathVariable Long id, HttpSession session, Model model) {
        List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
        model.addAttribute("numbers", numbers);
        return "payments/eighthCategory";
    }

    @RequestMapping(value = "/payment/ERIP/legal", method = RequestMethod.POST)
    public String addEighthCategory(@ModelAttribute OperationDTO operationDTO,
                                    Model model, HttpSession session) {
        AccountDTO account = accountService.getCurrentAccountByNumber(operationDTO.getAccount());
        int flag = account.getSum().compareTo(operationDTO.getSum());
        if ( flag == 1 || flag == 0 ) {
            BigDecimal sum = account.getSum().subtract(operationDTO.getSum());
            accountService.updateSum(account.getNumber(), sum);
            operationDTO.setCurrency(account.getCurrency());
            operationService.addNewOperation(operationDTO);
            return "redirect:/user/main";
        } else {
            model.addAttribute("error", "На вашем счете недостаточно средств");
            List<AccountDTO> numbers = accountService.getCurrentAccountForUser((String) session.getAttribute("user"));
            model.addAttribute("numbers", numbers);
            model.addAttribute("id", operationDTO.getPayment());
            return "payments/eighthCategory";
        }
    }
}
