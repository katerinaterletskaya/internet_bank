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
            System.out.println(depositDTO.getCurrency());
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
            if(accountRequestDTO.getType().equals(AccountType.CREDIT.name()))
                accountRequest.setType(AccountType.CREDIT);
            else if(accountRequestDTO.getType().equals(AccountType.DEPOSIT.name()))
                accountRequest.setType(AccountType.DEPOSIT);
            else if(accountRequestDTO.getType().equals(AccountType.CURRENT.name()))
                accountRequest.setType(AccountType.CURRENT);
            if(accountRequestDTO.getCurrency().equals(Currency.USD.name()))
                accountRequest.setCurrency(Currency.USD);
            else if(accountRequestDTO.getCurrency().equals(Currency.EUR.name()))
                accountRequest.setCurrency(Currency.EUR);
            else if(accountRequestDTO.getCurrency().equals(Currency.RUB.name()))
                accountRequest.setCurrency(Currency.RUB);
            else if(accountRequestDTO.getCurrency().equals(Currency.BYN.name()))
                accountRequest.setCurrency(Currency.BYN);
            return accountRequest;
        } else
            return null;
    }
}