package terletskayasamuseva;

import terletskayasamuseva.model.Deposit;

import java.util.List;

public interface DepositDAO extends GenericDAO<Deposit, Long>{
    List<Deposit> getDepositByParameter(Deposit deposit);
}
