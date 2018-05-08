package terletskayasamuseva;

import terletskayasamuseva.model.Account;
import terletskayasamuseva.model.AccountType;
import terletskayasamuseva.model.Currency;

import java.util.List;

public interface AccountDAO extends GenericDAO<Account, Long>{
    String getLastNumberCurrentAccount(AccountType type, Currency currency);
    List getAccountForUser(String username, AccountType type);
    List<String> getCurrentAccountForUser(String passport);
}
