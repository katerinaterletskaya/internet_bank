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
public class DepositServiceImpl implements DepositService {

    private static final Logger logger = Logger.getLogger(DepositServiceImpl.class);

    @Autowired
    private DepositDAO depositDAO;
    @Autowired
    private AccountRequestDAO accountRequestDAO;
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<DepositDTO> getAll() {
        Collection<Deposit> deposits = depositDAO.findAll();
        List<DepositDTO> depositDTOList = new ArrayList<>();
        for (Deposit deposit : deposits) {
            depositDTOList.add(Converter.convert(deposit));
        }
        return depositDTOList;
    }

    @Override
    public DepositDTO getDepositsByParameter(DepositDTO deposit) {
        Deposit deposit1 = depositDAO.getDepositByParameter(Converter.convert(deposit));
        return Converter.convert(deposit1);
    }

    @Override
    public boolean getDepositByName(String name) {
        if ( depositDAO.getDepositByName(name) != null )
            return true;
        else
            return false;
    }

    @Override
    public List<AccountRequestDTO> getRequestForDeposit() {
        List<AccountRequest> requestForAccount = accountRequestDAO.getRequestForDeposit();
        List<AccountRequestDTO> requestList = new ArrayList<>();
        for (AccountRequest request : requestForAccount) {
            requestList.add(Converter.convert(request));
        }
        return requestList;
    }

    @Override
    public void updateRequestForDeposit(AccountRequestDTO accountRequestDTO) {
        accountRequestDAO.changeAccountRequestStatus(Converter.convert(accountRequestDTO));
    }

    @Override
    public void addDepositForUser(String passport, String currency, BigDecimal sum) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Currency currency1 = Currency.valueOf(currency);
        String accountNumber;
        String number = accountDAO.getLastNumberCurrentAccount(AccountType.DEPOSIT, currency1);
        if ( number == null )
            accountNumber = NumberAccountCalculator.calculateFirstAccountNumber(AccountType.DEPOSIT, currency1);
        else
            accountNumber = NumberAccountCalculator.calculateAccountNumber(number.substring(13, 28), currency1, AccountType.DEPOSIT);
        Account account = new Account();
        account.setAccountType(AccountType.DEPOSIT);
        account.setNumber(accountNumber);
        account.setCurrency(currency1);
        account.setSum(sum);
        account.setDataOpen(Date.valueOf(ft.format(new java.util.Date())));
        UserInformation user = userDAO.getUserByPassport(passport);
        account.setUser(user);
        accountDAO.add(account);
    }

    @Override
    public boolean addDeposit(DepositDTO depositDTO) {
        Long add = depositDAO.add(Converter.convert(depositDTO));
        if ( add != null )
            return true;
        else
            return false;
    }
}
