package ru.bagautdinov.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bagautdinov.forms.UserRegistrationForm;
import ru.bagautdinov.forms.mappers.UserRegistrationFormMapper;
import ru.bagautdinov.models.User;
import ru.bagautdinov.repository.UserRepository;
import ru.bagautdinov.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveNewUser(UserRegistrationForm form) {
        User user = UserRegistrationFormMapper.transform(form);
        userRepository.save(user);
    }
}
