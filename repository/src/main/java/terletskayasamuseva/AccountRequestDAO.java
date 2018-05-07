package terletskayasamuseva;

import terletskayasamuseva.model.AccountRequest;

import java.util.List;

public interface AccountRequestDAO extends GenericDAO<AccountRequest, Long>{
    List<AccountRequest> getRequestForAccount();
    List<AccountRequest> getRequestForDeposit();
    List<AccountRequest> getRequestForCredit();
    void changeAccountRequestStatus(AccountRequest accountRequest);
    void changeAccountRequestStatusFromCurrentAccount(AccountRequest accountRequest);
}
