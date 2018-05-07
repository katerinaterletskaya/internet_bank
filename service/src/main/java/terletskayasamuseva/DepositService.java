package terletskayasamuseva;

import terletskayasamuseva.model.AccountRequestDTO;
import terletskayasamuseva.model.DepositDTO;

import java.math.BigDecimal;
import java.util.List;

public interface DepositService {
    List<DepositDTO> getAll();
    List<DepositDTO> getDepositsByParameter(DepositDTO deposit);
    List<AccountRequestDTO> getRequestForDeposit();
    void updateRequestForDeposit(AccountRequestDTO accountRequestDTO);
    void addDepositForUser(String passport, String currency, BigDecimal sum);
}
