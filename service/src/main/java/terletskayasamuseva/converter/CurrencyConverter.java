package terletskayasamuseva.converter;

import terletskayasamuseva.model.Currency;
import terletskayasamuseva.model.CurrencyKurs;
import terletskayasamuseva.model.CurrencyKursDTO;

public class CurrencyConverter {
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
}