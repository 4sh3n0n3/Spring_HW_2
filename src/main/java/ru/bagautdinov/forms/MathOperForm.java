package ru.bagautdinov.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class MathOperForm {

    @NotEmpty(message="The input mustn't be empty!")
    @Pattern(regexp="^\\d+$", message="Wrong number!")
    private String number;

    @NotEmpty(message="The function mustn't be empty!")
    private String function;

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getFunction() {
        return function;
    }
    public void setFunction(String function) {
        this.function = function;
    }
}
