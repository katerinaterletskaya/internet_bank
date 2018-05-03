package terletskayasamuseva.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import terletskayasamuseva.model.UserDTO;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {
    private static final Logger logger = Logger.getLogger(UserValidator.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "username", "user.name.empty");
        UserDTO user = (UserDTO) o;
        logger.info(user.getUsername());
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(user.getUsername()).matches())) {
            errors.rejectValue("username", "user.username.invalid");
        }
        pattern = Pattern.compile("^[a-zA-Z-]{2,30}$");
        if (!(pattern.matcher(user.getSurname()).matches())) {
            errors.rejectValue("surname", "user.surname.invalid");
        }
        if (!(pattern.matcher(user.getName()).matches())) {
            errors.rejectValue("name", "user.name.invalid");
        }
        if (!(pattern.matcher(user.getPatronymic()).matches())) {
            errors.rejectValue("patronymic", "user.patronymic.invalid");
        }
        pattern = Pattern.compile("^[A-Z0-9]{14}$");
        if (!(pattern.matcher(user.getPassport()).matches())) {
            errors.rejectValue("passport", "user.passport.invalid");
        }
    }
}
