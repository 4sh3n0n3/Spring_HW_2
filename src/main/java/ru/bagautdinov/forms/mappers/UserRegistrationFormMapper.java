package ru.bagautdinov.forms.mappers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.bagautdinov.forms.UserRegistrationForm;
import ru.bagautdinov.models.User;
import ru.bagautdinov.models.enums.UserRoles;

public class UserRegistrationFormMapper {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User transform(UserRegistrationForm form) {
        if (form == null) {
            return null;
        }
        User user = new User();
        user.setUsername(form.getUsername());
        user.setRole(UserRoles.ROLE_USER);
        user.setEmail(form.getEmail());
        user.setPassword(encoder.encode(form.getPassword()));
        return user;
    }
}
