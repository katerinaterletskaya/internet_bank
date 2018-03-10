package terletskayasamuseva.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import terletskayasamuseva.UserDAO;
import terletskayasamuseva.UserService;
import terletskayasamuseva.converter.Converter;
import terletskayasamuseva.model.Role;
import terletskayasamuseva.model.User;
import terletskayasamuseva.model.UserDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserDTO user) {
        User userToDatabase = Converter.convert(user);
        userToDatabase.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDAO.add(userToDatabase);
    }

    @Override
    public void update(UserDTO user) {
        User userToDatabase = Converter.convert(user);
        userToDatabase.setId(userDAO.getIdUserByUserName(user.getUsername()));
        userDAO.updateUser(userToDatabase);
    }

    @Override
    public List<UserDTO> getAll() {
        Collection<User> users = userDAO.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
            userDTOList.add(Converter.convert(user));
        }
        return userDTOList;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return Converter.convert(userDAO.getUserByEmail(email));
    }

    @Override
    public UserDTO getUser(String email) {
        return Converter.convert(userDAO.getUser(email));
    }

    @Override
    public boolean findUser(String username, String password) {
        User user = userDAO.getUserByEmail(username);
        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updatePassword(String username, String password) {
        User user = userDAO.getUserByEmail(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userDAO.updatePassword(user);
    }

    @Override
    public void updateRole(String username, String role) {
        User user = userDAO.getUserByEmail(username);
        if (role.equals(Role.ROLE_ADMIN.name())) {
            user.setRole(Role.ROLE_ADMIN);
        } else if (role.equals(Role.ROLE_USER.name())) {
            user.setRole(Role.ROLE_USER);
        }
        userDAO.updateRole(user);
    }
}
