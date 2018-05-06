package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import terletskayasamuseva.*;
import terletskayasamuseva.converter.Converter;
import terletskayasamuseva.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private static final Logger logger = Logger.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private AccountRequestDAO accountRequestDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public void addAccountRequest(AccountRequestDTO request, String username) {
        AccountRequest accountRequest = Converter.convert(request);
        accountRequest.setUser(userDAO.getUser(username).getUserInformation());
        accountRequestDAO.add(accountRequest);
    }
}