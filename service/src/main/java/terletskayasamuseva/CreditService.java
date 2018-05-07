package terletskayasamuseva;

import terletskayasamuseva.model.AccountRequestDTO;

import java.math.BigDecimal;
import java.util.List;

public interface CreditService {
    List<AccountRequestDTO> getRequestForCredit();
    void changeCreditRequestStatus(AccountRequestDTO accountRequestDTO);
    void addCreditForUser(String passport, BigDecimal sum);
}
