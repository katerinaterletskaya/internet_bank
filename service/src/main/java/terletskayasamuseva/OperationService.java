package terletskayasamuseva;

import terletskayasamuseva.model.*;

import java.math.BigDecimal;
import java.util.List;

public interface OperationService {
    List<CurrencyKursDTO> getCurrency();

    void changeCurrency(String currency, BigDecimal cost, BigDecimal sale);

    void addNewOperation(OperationDTO operationDTO);

    List<OperationDTO> getOperations(String number);

    void addTransaction(TransactionDTO transactionDTO, String numberAccount);

    List<OperationDTO> getOperationsWithParameter(String number, String firstDate, String secondDate, String date);

    List<TransactionDTO> getTransactionsWithParameter(String number, String firstDate, String secondDate, String date);
}