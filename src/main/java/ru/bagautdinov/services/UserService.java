package ru.bagautdinov.services;

import org.springframework.stereotype.Service;
import ru.bagautdinov.forms.UserRegistrationForm;
import ru.bagautdinov.models.MathOper;

public interface UserService {
    void saveNewUser(UserRegistrationForm form);
}
