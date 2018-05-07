package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import terletskayasamuseva.*;
import terletskayasamuseva.calculator.NumberAccountCalculator;
import terletskayasamuseva.converter.Converter;
import terletskayasamuseva.model.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private static final Logger logger = Logger.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private AccountRequestDAO accountRequestDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public void addAccountRequest(AccountRequestDTO request, String username) {
        AccountRequest accountRequest = Converter.convert(request);
        accountRequest.setUser(userDAO.getUser(username).getUserInformation());
        accountRequestDAO.add(accountRequest);
    }

    @Override
    public List<AccountRequestDTO> getAccountRequest() {
        List<AccountRequest> requestForAccount = accountRequestDAO.getRequestForAccount();
        List<AccountRequestDTO> requestList = new ArrayList<>();
        for (AccountRequest request : requestForAccount) {
            requestList.add(Converter.convert(request));
        }
        return requestList;
    }

    @Override
    public void changeAccountRequestStatus(AccountRequestDTO accountRequestDTO) {
        accountRequestDAO.changeAccountRequestStatusFromCurrentAccount(Converter.convert(accountRequestDTO));
    }

    @Override
    public void addCurrentAccountForUser(String passport, String currency, BigDecimal sum) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Currency currency1 = Currency.valueOf(currency);
        String accountNumber;
        String number = accountDAO.getLastNumberCurrentAccount(AccountType.CURRENT, currency1);
        if ( number == null )
            accountNumber = NumberAccountCalculator.calculateFirstAccountNumber(AccountType.CURRENT, currency1);
        else
            accountNumber = NumberAccountCalculator.calculateAccountNumber(number.substring(13, 28), currency1, AccountType.CREDIT);
        Account account = new Account();
        account.setAccountType(AccountType.CURRENT);
        account.setNumber(accountNumber);
        account.setCurrency(currency1);
        account.setSum(sum);
        account.setDataOpen(Date.valueOf(ft.format(new java.util.Date())));
        logger.info(account.toString());
        accountDAO.addNewAccount(account, passport);
    }
}