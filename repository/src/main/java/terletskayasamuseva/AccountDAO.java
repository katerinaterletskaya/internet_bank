package terletskayasamuseva;

import terletskayasamuseva.model.Account;
import terletskayasamuseva.model.AccountType;
import terletskayasamuseva.model.Currency;

public interface AccountDAO extends GenericDAO<Account, Long>{
    String getLastNumberCurrentAccount(AccountType type, Currency currency);
    void addNewAccount(Account account, String passport);
}
