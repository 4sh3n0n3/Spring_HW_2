package ru.bagautdinov.forms.mappers;

import ru.bagautdinov.forms.MathOperForm;
import ru.bagautdinov.models.MathOper;

public class MathOperFormMapper {

    public static MathOper transform(MathOperForm form) {
        if (form == null) return null;
        MathOper op = new MathOper();
        op.setFunction(form.getFunction());
        op.setNumber(form.getNumber());
        return op;
    }
}
