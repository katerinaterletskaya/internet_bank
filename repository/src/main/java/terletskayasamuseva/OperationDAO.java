package terletskayasamuseva;

import terletskayasamuseva.model.Operation;
import terletskayasamuseva.model.Transaction;

import java.sql.Date;
import java.util.List;

public interface OperationDAO extends GenericDAO<Operation, Long> {
    List<Operation> getOperations(String number);
    Long saveTransaction(Transaction entity);
    List<Operation> getOperationWithParameter(Date firstDate, Date secondDate, String numberAccount);
    List<Operation> getOperationForThisDay(Date date, String numberAccount);
    List<Operation> getOperationAfterDay(Date date, String numberAccount);
    List<Operation> getOperationUtilDay(Date date, String numberAccount);
    List<Transaction> getTransactionWithParameter(Date firstDate, Date secondDate, String numberAccount);
    List<Transaction> getTransactionForThisDay(Date date, String numberAccount);
    List<Transaction> getTransactionAfterDay(Date date, String numberAccount);
    List<Transaction> getTransactionUtilDay(Date date, String numberAccount);
    List<Transaction> getAllTransaction(String numberAccount);
}
