package terletskayasamuseva;

import terletskayasamuseva.model.Operation;

import java.util.List;


public interface OperationDAO extends GenericDAO<Operation, Long>{
    List<Operation> getOperations(String number);
}
