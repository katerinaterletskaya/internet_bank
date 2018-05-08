package terletskayasamuseva;

import terletskayasamuseva.model.Currency;
import terletskayasamuseva.model.CurrencyKurs;

import java.math.BigDecimal;

public interface CurrencyDAO extends GenericDAO<CurrencyKurs, Long> {
    void changeCurrency(Currency currency, BigDecimal cost, BigDecimal sale);
}
