package terletskayasamuseva;

import terletskayasamuseva.model.AccountRequestDTO;

public interface AccountService {
    void addAccountRequest(AccountRequestDTO request, String username);
}
