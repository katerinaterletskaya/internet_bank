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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CreditServiceImpl implements CreditService {
    private static final Logger logger = Logger.getLogger(CreditServiceImpl.class);

    @Autowired
    private AccountRequestDAO accountRequestDAO;
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CreditDAO creditDAO;

    @Override
    public List<CreditDTO> getAll() {
        Collection<Credit> credits = creditDAO.findAll();
        List<CreditDTO> creditDTOList = new ArrayList<>();
        for (Credit credit : credits) {
            creditDTOList.add(Converter.convert(credit));
        }
        return creditDTOList;
    }

    @Override
    public List<AccountRequestDTO> getRequestForCredit() {
        List<AccountRequest> requestForAccount = accountRequestDAO.getRequestForCredit();
        List<AccountRequestDTO> requestList = new ArrayList<>();
        for (AccountRequest request : requestForAccount) {
            requestList.add(Converter.convert(request));
        }
        return requestList;
    }

    @Override
    public void changeCreditRequestStatus(AccountRequestDTO accountRequestDTO) {
        accountRequestDAO.changeAccountRequestStatus(Converter.convert(accountRequestDTO));
    }

    @Override
    public void addCreditForUser(String passport, String currency, BigDecimal sum) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Currency currency1 = Currency.valueOf(currency);
        String accountNumber;
        String number = accountDAO.getLastNumberCurrentAccount(AccountType.CREDIT, currency1);
        if ( number == null )
            accountNumber = NumberAccountCalculator.calculateFirstAccountNumber(AccountType.CREDIT, currency1);
        else
            accountNumber = NumberAccountCalculator.calculateAccountNumber(number.substring(13, 28), currency1, AccountType.CREDIT);
        Account account = new Account();
        account.setAccountType(AccountType.CREDIT);
        account.setNumber(accountNumber);
        account.setCurrency(currency1);
        account.setSum(sum);
        account.setDataOpen(Date.valueOf(ft.format(new java.util.Date())));
        UserInformation user = userDAO.getUserByPassport(passport);
        account.setUser(user);
        accountDAO.add(account);
    }

    @Override
    public boolean findCreditByName(String name) {
        if ( creditDAO.getCreditByName(name) != null )
            return true;
        else
            return false;
    }

    @Override
    public boolean addCredit(CreditDTO creditDTO) {
        Long add = creditDAO.add(Converter.convert(creditDTO));
        if ( add != null )
            return true;
        else
            return false;
    }
}