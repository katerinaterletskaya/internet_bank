package terletskayasamuseva;


import terletskayasamuseva.model.UserDTO;

import java.util.List;

public interface UserService {
    void save(UserDTO user);
    void update(UserDTO user);
    List<UserDTO> getAll();
    UserDTO getUserByEmail(String email);
    UserDTO getUser(String email);
    boolean findUser(String username, String password);
    void updateRole(String username, String role);
    void updatePassword(String username, String password);
    void updateUsername(String username, String newUsername);
}
