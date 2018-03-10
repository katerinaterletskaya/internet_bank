package terletskayasamuseva.converter;


import terletskayasamuseva.model.Role;
import terletskayasamuseva.model.User;
import terletskayasamuseva.model.UserDTO;

public class Converter {
    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole().toString());
        return userDTO;
    }

    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getUsername());
        if (userDTO.getRole() == null) {
            user.setRole(Role.ROLE_USER);
        }
        return user;
    }
}
