package ru.bagautdinov.services;

import org.springframework.stereotype.Service;
import ru.bagautdinov.models.MathOper;
import ru.bagautdinov.models.User;

public interface MathOperService {
    void saveNewOper(User owner, MathOper operation);
    void setLastOper(MathOper oper);
    MathOper doMath(MathOper oper);
}
