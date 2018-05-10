package terletskayasamuseva;

import terletskayasamuseva.model.Deposit;

import java.util.List;

public interface DepositDAO extends GenericDAO<Deposit, Long>{
    Deposit getDepositByParameter(Deposit deposit);
    Deposit getDepositByName(String name);
}
