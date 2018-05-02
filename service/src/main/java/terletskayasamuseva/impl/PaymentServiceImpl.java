package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import terletskayasamuseva.PaymentDAO;
import terletskayasamuseva.PaymentService;
import terletskayasamuseva.UserDAO;
import terletskayasamuseva.UserService;
import terletskayasamuseva.converter.Converter;
import terletskayasamuseva.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private static final Logger logger = Logger.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentDAO paymentDAO;

    @Override
    public List<PaymentDTO> getAll() {
        Collection<Payment> payments = paymentDAO.findAll();
        List<PaymentDTO> paymentDTOList = new ArrayList<>();
        for (Payment payment : payments) {
            paymentDTOList.add(Converter.convert(payment));
        }
        return paymentDTOList;
    }
}
