package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import terletskayasamuseva.AccountDAO;
import terletskayasamuseva.AccountRequestDAO;
import terletskayasamuseva.CreditService;
import terletskayasamuseva.calculator.NumberAccountCalculator;
import terletskayasamuseva.converter.Converter;
import terletskayasamuseva.model.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CreditServiceImpl implements CreditService {
    private static final Logger logger = Logger.getLogger(CreditServiceImpl.class);

    @Autowired
    private AccountRequestDAO accountRequestDAO;
    @Autowired
    private AccountDAO accountDAO;

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
    public void addCreditForUser(String passport, BigDecimal sum) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String accountNumber;
        String number = accountDAO.getLastNumberCurrentAccount(AccountType.CREDIT, Currency.BYN);
        if ( number == null )
            accountNumber = NumberAccountCalculator.calculateFirstAccountNumber(AccountType.CREDIT, Currency.BYN);
        else
            accountNumber = NumberAccountCalculator.calculateAccountNumber(number.substring(13, 28), Currency.BYN, AccountType.CREDIT);
        Account account = new Account();
        account.setAccountType(AccountType.CREDIT);
        account.setNumber(accountNumber);
        account.setCurrency(Currency.BYN);
        account.setSum(sum);
        account.setDataOpen(Date.valueOf(ft.format(new java.util.Date())));
        logger.info(account.toString());
        accountDAO.addNewAccount(account, passport);
    }
}