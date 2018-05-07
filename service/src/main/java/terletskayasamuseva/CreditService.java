package terletskayasamuseva;

import terletskayasamuseva.model.AccountRequestDTO;
import terletskayasamuseva.model.CreditDTO;

import java.math.BigDecimal;
import java.util.List;

public interface CreditService {
    List<CreditDTO> getAll();
    List<AccountRequestDTO> getRequestForCredit();
    void changeCreditRequestStatus(AccountRequestDTO accountRequestDTO);
    void addCreditForUser(String passport, String currency, BigDecimal sum);
    boolean findCreditByName(String name);
    boolean addCredit(CreditDTO creditDTO);
}
