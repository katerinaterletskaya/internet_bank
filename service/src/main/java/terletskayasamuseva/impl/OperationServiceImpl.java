package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import terletskayasamuseva.CurrencyDAO;
import terletskayasamuseva.OperationService;
import terletskayasamuseva.converter.Converter;
import terletskayasamuseva.model.CurrencyKurs;
import terletskayasamuseva.model.CurrencyKursDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class OperationServiceImpl implements OperationService {
    private static final Logger logger = Logger.getLogger(OperationServiceImpl.class);

    @Autowired
    private CurrencyDAO currencyDAO;
    
    @Override
    public List<CurrencyKursDTO> getCurrency() {
        Collection<CurrencyKurs> currencyKurs = currencyDAO.findAll();
        List<CurrencyKursDTO> currencyKursDTOList = new ArrayList<>();
        for (CurrencyKurs kurs : currencyKurs) {
            currencyKursDTOList.add(Converter.convert(kurs));
        }
        return currencyKursDTOList;
    }
}
