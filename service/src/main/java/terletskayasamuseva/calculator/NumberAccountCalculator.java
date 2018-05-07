package terletskayasamuseva.calculator;

import terletskayasamuseva.model.AccountType;
import terletskayasamuseva.model.Currency;

public class NumberAccountCalculator {
    private static final String prefix = "BY13CBRB";
    private static final String physical = "3014";
    private static final String EUR = "978";
    private static final String RUB = "643";
    private static final String USD = "840";
    private static final String BYN = "933";
    private static final String deposit = "1";
    private static final String credit = "2";
    private static final String current = "3";

    public static String calculateAccountNumber(String number, Currency currency, AccountType type) {
        StringBuilder returnNumber = new StringBuilder(prefix + physical);
        Long num = Long.parseLong(number);
        num++;
        if ( type == AccountType.CREDIT )
            returnNumber.append(credit);
        else if ( type == AccountType.DEPOSIT )
            returnNumber.append(deposit);
        else if ( type == AccountType.CURRENT )
            returnNumber.append(current);
        if ( currency == Currency.BYN )
            returnNumber.append(BYN);
        else if ( currency == Currency.USD )
            returnNumber.append(USD);
        else if ( currency == Currency.EUR )
            returnNumber.append(EUR);
        else if ( currency == Currency.RUB )
            returnNumber.append(RUB);
        for (int i = 0; i < 12 - num.toString().length(); i++)
            returnNumber.append("0");
        returnNumber.append(num);
        return returnNumber.toString();
    }

    public static String calculateFirstAccountNumber(AccountType type, Currency currency) {
        String numberAccount = prefix + physical;
        if ( type == AccountType.CREDIT )
            numberAccount += credit;
        else if ( type == AccountType.DEPOSIT )
            numberAccount += deposit;
        else if ( type == AccountType.CURRENT )
            numberAccount += current;
        if ( currency == Currency.RUB ) {
            numberAccount += RUB;
        } else if ( currency == Currency.BYN ) {
            numberAccount += BYN;
        } else if ( currency == Currency.EUR ) {
            numberAccount += EUR;
        } else if ( currency == Currency.USD ) {
            numberAccount += USD;
        }
        numberAccount += "000000000000";
        return numberAccount;
    }
}