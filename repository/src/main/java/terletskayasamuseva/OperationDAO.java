package terletskayasamuseva;

import terletskayasamuseva.model.Operation;
import terletskayasamuseva.model.Transaction;

import java.util.List;


public interface OperationDAO extends GenericDAO<Operation, Long> {
    List<Operation> getOperations(String number);
    Long saveTransaction(Transaction entity);
}
