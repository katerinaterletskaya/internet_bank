package terletskayasamuseva;


import terletskayasamuseva.model.User;
import terletskayasamuseva.model.UserInformation;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {
    User getUserByEmail(String email);
    User getUser(String email);
    UserInformation getUserByPassport(String passport);
    Long getIdUserByUserName(String email);
    void updateUser(User user);
    void updatePassword(User user);
    void updateLogin(User user);
    void updateRole(User user);
    List<User> getUserForAdmin();
    UserInformation getUserForAccount(User user);
}
