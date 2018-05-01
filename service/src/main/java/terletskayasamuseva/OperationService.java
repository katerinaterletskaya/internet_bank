package terletskayasamuseva;

import terletskayasamuseva.model.CurrencyKursDTO;

import java.util.List;

public interface OperationService {
    List<CurrencyKursDTO> getCurrency();
}