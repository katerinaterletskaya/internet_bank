package terletskayasamuseva.converter;

import terletskayasamuseva.model.Currency;
import terletskayasamuseva.model.CurrencyKurs;
import terletskayasamuseva.model.CurrencyKursDTO;

public class CurrencyConverter {
    public static CurrencyKursDTO convert(CurrencyKurs currencyKurs) {
        if (currencyKurs != null ) {
            CurrencyKursDTO currencyKursDTO = new CurrencyKursDTO();
            currencyKursDTO.setId(currencyKurs.getId());
            currencyKursDTO.setSale(currencyKurs.getSale());
            currencyKursDTO.setCost(currencyKurs.getCost());
            if(currencyKurs.getCurrency().equals(Currency.BYN.name()))
                currencyKursDTO.setCurrency(Currency.BYN.name());
            else if(currencyKurs.getCurrency().equals(Currency.EUR.name()))
                currencyKursDTO.setCurrency(Currency.EUR.name());
            else if(currencyKurs.getCurrency().equals(Currency.RUB.name()))
                currencyKursDTO.setCurrency(Currency.RUB.name());
            else if(currencyKurs.getCurrency().equals(Currency.USD.name()))
                currencyKursDTO.setCurrency(Currency.USD.name());
            return currencyKursDTO;
        } else
            return null;
    }
}
