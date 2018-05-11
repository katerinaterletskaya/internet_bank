package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import terletskayasamuseva.*;
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
public class OperationServiceImpl implements OperationService {
    private static final Logger logger = Logger.getLogger(OperationServiceImpl.class);

    @Autowired
    private CurrencyDAO currencyDAO;
    @Autowired
    private PaymentDAO paymentDAO;
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private OperationDAO operationDAO;

    @Override
    public List<CurrencyKursDTO> getCurrency() {
        Collection<CurrencyKurs> currencyKurs = currencyDAO.findAll();
        List<CurrencyKursDTO> currencyKursDTOList = new ArrayList<>();
        for (CurrencyKurs kurs : currencyKurs) {
            currencyKursDTOList.add(Converter.convert(kurs));
        }
        return currencyKursDTOList;
    }

    @Override
    public void changeCurrency(String currency, BigDecimal cost, BigDecimal sale) {
        Currency currency1 = Currency.valueOf(currency);
        currencyDAO.changeCurrency(currency1, cost, sale);
    }

    @Override
    public void addNewOperation(OperationDTO operationDTO) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Operation operation = Converter.convert(operationDTO);
        Payment payment = paymentDAO.findById(operationDTO.getPayment());
        Account account = accountDAO.getCurrentAccountByNumber(operationDTO.getAccount());
        operation.setDate(Date.valueOf(ft.format(new java.util.Date())));
        operation.setAccount(account);
        operation.setPayment(payment);
        operationDAO.add(operation);
    }

    @Override
    public List<OperationDTO> getOperations(String number) {
        List<OperationDTO> operationList = new ArrayList<>();
        for (PaymentCategory category : paymentDAO.getAll()) {
            OperationDTO operationDTO = new OperationDTO();
            operationDTO.setPaymentCategory(category.getName());
            operationDTO.setSum(new BigDecimal(0.0));
            operationList.add(operationDTO);
        }
        for (Operation operation : operationDAO.getOperations(number)) {
            for (OperationDTO operationDTO : operationList) {
                if ( operationDTO.getPaymentCategory().equals(operation.getPayment().getCategory().getName()) )
                    operationDTO.setSum(operationDTO.getSum().add(operation.getSum()));
            }
        }
        return operationList;
    }

    @Override
    public void addTransaction(TransactionDTO transactionDTO, String numberAccount) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Account account = accountDAO.getCurrentAccountByNumber(numberAccount);
        Transaction transaction = Converter.convert(transactionDTO);
        transaction.setDate(Date.valueOf(ft.format(new java.util.Date())));
        transaction.setAccount(account);
        operationDAO.saveTransaction(transaction);
    }

    @Override
    public List<OperationDTO> getOperationsWithParameter(String number, String firstDate, String secondDate, String date) {
        List<OperationDTO> operations = new ArrayList<>();
        List<Operation> operationList;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        if ( date.equals("today") ) {
            operationList = operationDAO.getOperationForThisDay(Date.valueOf(ft.format(new java.util.Date())), number);
        } else if ( date.equals("month") ) {
            Date date1 = Date.valueOf(ft.format(new java.util.Date()));
            String[] split = date1.toString().split("-");
            Date date2 = Date.valueOf(split[0] + "-" + split[1] + "-01");
            operationList = operationDAO.getOperationWithParameter(date2, date1, number);
        } else {
            if ( !firstDate.equals("") && secondDate.equals("") ) {
                Date date1 = Date.valueOf(firstDate);
                operationList = operationDAO.getOperationAfterDay(date1, number);
            } else if ( firstDate.equals("") && !secondDate.equals("") ) {
                Date date2 = Date.valueOf(secondDate);
                operationList = operationDAO.getOperationUtilDay(date2, number);
            } else if ( !firstDate.equals("") && !secondDate.equals("") ) {
                Date date1 = Date.valueOf(firstDate);
                Date date2 = Date.valueOf(secondDate);
                operationList = operationDAO.getOperationWithParameter(date1, date2, number);
            } else {
                operationList = operationDAO.getOperations(number);
            }
        }
        for (Operation operation : operationList) {
            operations.add(Converter.convert(operation));
        }
        return operations;
    }

    @Override
    public List<TransactionDTO> getTransactionsWithParameter(String number, String firstDate, String secondDate, String date) {
        List<TransactionDTO> transactions = new ArrayList<>();
        List<Transaction> transactionList;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        if ( date.equals("today") ) {
            transactionList = operationDAO.getTransactionForThisDay(Date.valueOf(ft.format(new java.util.Date())), number);
        } else if ( date.equals("month") ) {
            Date date1 = Date.valueOf(ft.format(new java.util.Date()));
            String[] split = date1.toString().split("-");
            Date date2 = Date.valueOf(split[0] + "-" + split[1] + "-01");
            transactionList = operationDAO.getTransactionWithParameter(date2, date1, number);
        } else {
            if ( !firstDate.equals("") && secondDate.equals("") ) {
                Date date1 = Date.valueOf(firstDate);
                transactionList = operationDAO.getTransactionAfterDay(date1, number);
            } else if ( firstDate.equals("") && !secondDate.equals("") ) {
                Date date2 = Date.valueOf(secondDate);
                transactionList = operationDAO.getTransactionUtilDay(date2, number);
            } else if ( !firstDate.equals("") && !secondDate.equals("") ) {
                Date date1 = Date.valueOf(firstDate);
                Date date2 = Date.valueOf(secondDate);
                transactionList = operationDAO.getTransactionWithParameter(date1, date2, number);
            } else {
                transactionList = operationDAO.getAllTransaction(number);
            }
        }
        for (Transaction transaction : transactionList) {
            transactions.add(Converter.convert(transaction));
        }
        return transactions;
    }
}
