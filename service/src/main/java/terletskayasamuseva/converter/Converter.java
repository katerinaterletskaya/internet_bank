package terletskayasamuseva.converter;


import terletskayasamuseva.model.*;

public class Converter {
    public static UserDTO convert(User user) {
        if ( user != null ) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(user.getLogin());
            userDTO.setPassword(user.getPassword());
            userDTO.setRole(user.getRole().name());
            if ( user.getUserInformation() != null ) {
                userDTO.setName(user.getUserInformation().getName());
                userDTO.setPatronymic(user.getUserInformation().getPatronymic());
                userDTO.setSurname(user.getUserInformation().getSurname());
                userDTO.setPassport(user.getUserInformation().getPassportNumber());
            }
            return userDTO;
        } else
            return null;
    }

    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getUsername());
        if ( userDTO.getRole() == null ) {
            user.setRole(Role.ROLE_USER);
        }
        user.setPassword(userDTO.getPassword());
        UserInformation userInformation = new UserInformation();
        userInformation.setName(userDTO.getName());
        userInformation.setPatronymic(userDTO.getPatronymic());
        userInformation.setSurname(userDTO.getSurname());
        userInformation.setPassportNumber(userDTO.getPassport());
        user.setUserInformation(userInformation);
        return user;
    }

    public static PaymentDTO convert(Payment payment) {
        if ( payment != null ) {
            PaymentDTO paymentDTO = new PaymentDTO();
            paymentDTO.setId(payment.getId());
            paymentDTO.setName(payment.getName());
            paymentDTO.setReceiverAccount(payment.getReceiverAccount());
            return paymentDTO;
        } else
            return null;
    }
}
