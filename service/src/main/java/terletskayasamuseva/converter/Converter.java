package terletskayasamuseva.converter;


import terletskayasamuseva.model.*;

public class Converter {
    public static UserDTO convert(User user) {
        if ( user != null ) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(user.getLogin());
            userDTO.setPassword(user.getPassword());
            userDTO.setRole(user.getRole().name());
            userDTO.setStatus(user.getStatus().name());
            if ( user.getUserInformation() != null ) {
                userDTO.setName(user.getUserInformation().getName());
                userDTO.setPatronymic(user.getUserInformation().getPatronymic());
                userDTO.setSurname(user.getUserInformation().getSurname());
                userDTO.setPassport(user.getUserInformation().getPassportNumber());
            }
            return userDTO;
        } else
            return null;
    }

    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getUsername());
        if ( userDTO.getRole() == null ) {
            user.setRole(Role.ROLE_USER);
        }
        if ( userDTO.getStatus() == null ) {
            user.setStatus(Status.UNLOCK);
        }
        user.setPassword(userDTO.getPassword());
        UserInformation userInformation = new UserInformation();
        userInformation.setName(userDTO.getName());
        userInformation.setPatronymic(userDTO.getPatronymic());
        userInformation.setSurname(userDTO.getSurname());
        userInformation.setPassportNumber(userDTO.getPassport());
        user.setUserInformation(userInformation);
        return user;
    }

    public static PaymentDTO convert(Payment payment) {
        if ( payment != null ) {
            PaymentDTO paymentDTO = new PaymentDTO();
            paymentDTO.setId(payment.getId());
            paymentDTO.setName(payment.getName());
            paymentDTO.setReceiverAccount(payment.getReceiverAccount());
            return paymentDTO;
        } else
            return null;
    }

    public static DepositDTO convert(Deposit deposit) {
        if ( deposit != null ) {
            DepositDTO depositDTO = new DepositDTO();
            depositDTO.setId(deposit.getId());
            depositDTO.setName(deposit.getName());
            if ( deposit.getCurrency() == Currency.BYN )
                depositDTO.setCurrency(Currency.BYN.name());
            else if ( deposit.getCurrency() == Currency.USD )
                depositDTO.setCurrency(Currency.USD.name());
            else if ( deposit.getCurrency() == Currency.EUR )
                depositDTO.setCurrency(Currency.EUR.name());
            else if ( deposit.getCurrency() == Currency.RUB )
                depositDTO.setCurrency(Currency.RUB.name());
            depositDTO.setMinSum(deposit.getMinSum());
            depositDTO.setPercent(deposit.getPercent());
            depositDTO.setPeriod(deposit.getPeriod());
            depositDTO.setReversal(deposit.getReversal());
            return depositDTO;
        } else
            return null;
    }

    public static Deposit convert(DepositDTO depositDTO) {
        if ( depositDTO != null ) {
            Deposit deposit = new Deposit();
            deposit.setName(depositDTO.getName());
            if ( depositDTO.getCurrency().equals(Currency.BYN.name()) )
                deposit.setCurrency(Currency.BYN);
            else if ( depositDTO.getCurrency().equals(Currency.USD.name()) )
                deposit.setCurrency(Currency.USD);
            else if ( depositDTO.getCurrency().equals(Currency.EUR.name()) )
                deposit.setCurrency(Currency.EUR);
            else if ( depositDTO.getCurrency().equals(Currency.RUB.name()) ) {
                deposit.setCurrency(Currency.RUB);
            }
            deposit.setMinSum(depositDTO.getMinSum());
            deposit.setPercent(depositDTO.getPercent());
            deposit.setPeriod(depositDTO.getPeriod());
            deposit.setReversal(depositDTO.getReversal());
            return deposit;
        } else
            return null;
    }

    public static CreditDTO convert(Credit credit) {
        if ( credit != null ) {
            CreditDTO creditDTO = new CreditDTO();
            creditDTO.setId(credit.getId());
            creditDTO.setName(credit.getName());
            if ( credit.getCurrency() == Currency.BYN )
                creditDTO.setCurrency(Currency.BYN.name());
            else if ( credit.getCurrency() == Currency.USD )
                creditDTO.setCurrency(Currency.USD.name());
            else if ( credit.getCurrency() == Currency.EUR )
                creditDTO.setCurrency(Currency.EUR.name());
            else if ( credit.getCurrency() == Currency.RUB )
                creditDTO.setCurrency(Currency.RUB.name());
            creditDTO.setMinSum(credit.getMinSum());
            creditDTO.setMaxSum(credit.getMaxSum());
            creditDTO.setPercent(credit.getPercent());
            creditDTO.setPeriod(credit.getPeriod());
            return creditDTO;
        } else
            return null;
    }

    public static Credit convert(CreditDTO creditDTO) {
        if ( creditDTO != null ) {
            Credit credit = new Credit();
            credit.setName(creditDTO.getName());
            if ( creditDTO.getCurrency().equals(Currency.BYN.name()) )
                credit.setCurrency(Currency.BYN);
            else if ( creditDTO.getCurrency().equals(Currency.USD.name()) )
                credit.setCurrency(Currency.USD);
            else if ( creditDTO.getCurrency().equals(Currency.EUR.name()) )
                credit.setCurrency(Currency.EUR);
            else if ( creditDTO.getCurrency().equals(Currency.RUB.name()) ) {
                credit.setCurrency(Currency.RUB);
            }
            credit.setMinSum(creditDTO.getMinSum());
            credit.setMaxSum(creditDTO.getMaxSum());
            credit.setPercent(creditDTO.getPercent());
            credit.setPeriod(creditDTO.getPeriod());
            return credit;
        } else
            return null;
    }

    public static CurrencyKursDTO convert(CurrencyKurs currencyKurs) {
        if ( currencyKurs != null ) {
            CurrencyKursDTO currencyKursDTO = new CurrencyKursDTO();
            currencyKursDTO.setId(currencyKurs.getId());
            currencyKursDTO.setSale(currencyKurs.getSale());
            currencyKursDTO.setCost(currencyKurs.getCost());
            if ( currencyKurs.getCurrency() == Currency.EUR )
                currencyKursDTO.setCurrency(Currency.EUR.name());
            else if ( currencyKurs.getCurrency() == Currency.RUB )
                currencyKursDTO.setCurrency(Currency.RUB.name());
            else if ( currencyKurs.getCurrency() == Currency.USD )
                currencyKursDTO.setCurrency(Currency.USD.name());
            return currencyKursDTO;
        } else
            return null;
    }

    public static AccountRequest convert(AccountRequestDTO accountRequestDTO) {
        if ( accountRequestDTO != null ) {
            AccountRequest accountRequest = new AccountRequest();
            accountRequest.setTelephone(accountRequestDTO.getTelephone());
            if ( accountRequestDTO.getStatus() == null )
                accountRequest.setStatus(false);
            if ( accountRequestDTO.getType() != null ) {
                if ( accountRequestDTO.getType().equals(AccountType.CREDIT.name()) )
                    accountRequest.setType(AccountType.CREDIT);
                else if ( accountRequestDTO.getType().equals(AccountType.DEPOSIT.name()) )
                    accountRequest.setType(AccountType.DEPOSIT);
                else if ( accountRequestDTO.getType().equals(AccountType.CURRENT.name()) )
                    accountRequest.setType(AccountType.CURRENT);
            }
            if ( accountRequestDTO.getCurrency() != null ) {
                if ( accountRequestDTO.getCurrency().equals(Currency.USD.name()) )
                    accountRequest.setCurrency(Currency.USD);
                else if ( accountRequestDTO.getCurrency().equals(Currency.EUR.name()) )
                    accountRequest.setCurrency(Currency.EUR);
                else if ( accountRequestDTO.getCurrency().equals(Currency.RUB.name()) )
                    accountRequest.setCurrency(Currency.RUB);
                else if ( accountRequestDTO.getCurrency().equals(Currency.BYN.name()) )
                    accountRequest.setCurrency(Currency.BYN);
            }
            return accountRequest;
        } else
            return null;
    }

    public static AccountRequestDTO convert(AccountRequest accountRequest) {
        if ( accountRequest != null ) {
            AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
            accountRequestDTO.setTelephone(accountRequest.getTelephone());
            if ( accountRequest.getCurrency() != null )
                accountRequestDTO.setCurrency(accountRequest.getCurrency().name());
            accountRequestDTO.setType(accountRequest.getType().name());
            accountRequestDTO.setStatus(accountRequest.getStatus());
            UserDTO userDTO = new UserDTO();
            userDTO.setPassport(accountRequest.getUser().getPassportNumber());
            userDTO.setSurname(accountRequest.getUser().getSurname());
            userDTO.setName(accountRequest.getUser().getName());
            userDTO.setPatronymic(accountRequest.getUser().getPatronymic());
            accountRequestDTO.setUser(userDTO);
            return accountRequestDTO;
        } else
            return null;
    }
}