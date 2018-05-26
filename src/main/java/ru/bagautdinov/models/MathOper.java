package ru.bagautdinov.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "math_gen", sequenceName = "math_seq", allocationSize = 1)
@Table(name = "math")
public class MathOper {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "math_gen")
    private long id;

    @NotNull(message="Число не может быть пустым")
    private String number;

    @NotNull(message="Мат. функция не может быть пустой")
    private String function;

    @ManyToOne
    @NotNull(message="Пользователь не может быть пустым")
    @JoinColumn
    private User owner;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setFunction(String function) {
        this.function = function;
    }
    public String getFunction() {
        return function;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "(" + number + ", " + function + ")";
    }

    public boolean isEmpty() {
        if (getNumber().equals("") || getFunction().equals("")) {
            return true;
        }
        return false;
    }
}
