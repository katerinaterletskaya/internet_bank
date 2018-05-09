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
                if(operationDTO.getPaymentCategory().equals(operation.getPayment().getCategory().getName()))
                    operationDTO.setSum(operationDTO.getSum().add(operation.getSum()));
            }
        }
        return operationList;
    }
}
