package terletskayasamuseva;

import terletskayasamuseva.model.CurrencyKursDTO;

import java.math.BigDecimal;
import java.util.List;

public interface OperationService {
    List<CurrencyKursDTO> getCurrency();
    void changeCurrency(String currency, BigDecimal cost, BigDecimal sale);
}