package terletskayasamuseva;


import terletskayasamuseva.model.User;

public interface UserDAO extends GenericDAO<User, Long> {
    User getUserByEmail(String email);
    User getUser(String email);
    Long getIdUserByUserName(String email);
    void updateUser(User user);
    void updatePassword(User user);
    void updateRole(User user);
}
