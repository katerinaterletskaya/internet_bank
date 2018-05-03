package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import terletskayasamuseva.DepositDAO;
import terletskayasamuseva.DepositService;
import terletskayasamuseva.PaymentDAO;
import terletskayasamuseva.converter.Converter;
import terletskayasamuseva.model.Deposit;
import terletskayasamuseva.model.DepositDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class DepositServiceImpl implements DepositService {

    private static final Logger logger = Logger.getLogger(DepositServiceImpl.class);

    @Autowired
    private DepositDAO depositDAO;

    @Override
    public List<DepositDTO> getAll() {
        Collection<Deposit> deposits = depositDAO.findAll();
        List<DepositDTO> depositDTOList = new ArrayList<>();
        for (Deposit deposit : deposits) {
            depositDTOList.add(Converter.convert(deposit));
        }
        return depositDTOList;
    }

    @Override
    public List<DepositDTO> getDepositsByParameter(DepositDTO deposit) {
        List<Deposit> deposits = depositDAO.getDepositByParameter(Converter.convert(deposit));
        List<DepositDTO> depositDTOList = new ArrayList<>();
        for (Deposit depositItem : deposits) {
            depositDTOList.add(Converter.convert(depositItem));
        }
        return depositDTOList;
    }
}
