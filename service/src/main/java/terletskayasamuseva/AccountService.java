package terletskayasamuseva;

import terletskayasamuseva.model.AccountDTO;
import terletskayasamuseva.model.AccountRequestDTO;


import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    void addAccountRequest(AccountRequestDTO request, String username);
    List<AccountRequestDTO> getAccountRequest();
    void changeAccountRequestStatus(AccountRequestDTO accountRequestDTO);
    void addCurrentAccountForUser(String passport, String currency, BigDecimal sum);
    Integer getNumberAccountForUser(String username, String type);
    List<AccountDTO> getAccountForUser(String username, String type);
    List<String> getNumberAccountForUser(String passport);
    List<AccountDTO> getCurrentAccountForUser(String username);
    AccountDTO getCurrentAccountByNumber(String number);
    void updateSum(String numberAccount, BigDecimal sum);
}
