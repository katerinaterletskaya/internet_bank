package terletskayasamuseva;

import terletskayasamuseva.model.AccountRequestDTO;
import terletskayasamuseva.model.DepositDTO;

import java.math.BigDecimal;
import java.util.List;

public interface DepositService {
    List<DepositDTO> getAll();
    DepositDTO getDepositsByParameter(DepositDTO deposit);
    boolean getDepositByName(String name);
    List<AccountRequestDTO> getRequestForDeposit();
    void updateRequestForDeposit(AccountRequestDTO accountRequestDTO);
    void addDepositForUser(String passport, String currency, BigDecimal sum);
    boolean addDeposit(DepositDTO depositDTO);
}
