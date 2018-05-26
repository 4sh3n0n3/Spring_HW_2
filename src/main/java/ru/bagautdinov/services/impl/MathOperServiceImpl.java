package ru.bagautdinov.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bagautdinov.models.MathOper;
import ru.bagautdinov.models.User;
import ru.bagautdinov.repository.MathOperRepository;
import ru.bagautdinov.services.MathOperService;

@Service
public class MathOperServiceImpl implements MathOperService {

    private MathOper lastOper;

    @Autowired
    private MathOperRepository mathOperRepository;


    @Override
    public void saveNewOper(User owner, MathOper operation) {
        operation.setOwner(owner);

        mathOperRepository.save(operation);
    }

    @Override
    public void setLastOper(MathOper oper) {
        this.lastOper = oper;
    }

    @Override
    public MathOper doMath(MathOper oper) {
        if (getLastOper() == null) {
            setLastOper(oper);
            return oper;
        }

        String act = lastOper.getFunction();
        double result = 0;
        switch (act) {
            case "+":
                result = add(oper);
                break;
            case "-":
                result = sub(oper);
                break;
            case "*":
                result = mul(oper);
                break;
            case "/":
                result = div(oper);
                break;
        }

        oper.setNumber(String.valueOf(result));

        if (!oper.getFunction().equals("=")) {
            setLastOper(oper);
        } else {
            setLastOper(null);
        }
        return oper;
    }

    private double add(MathOper oper) {
        return Double.valueOf(lastOper.getNumber()) + Double.valueOf(oper.getNumber());
    }
    private double sub(MathOper oper) {
        return Double.valueOf(lastOper.getNumber()) - Double.valueOf(oper.getNumber());
    }
    private double div(MathOper oper) {
        return Double.valueOf(lastOper.getNumber()) / Double.valueOf(oper.getNumber());
    }
    private double mul(MathOper oper) {
        return Double.valueOf(lastOper.getNumber()) * Double.valueOf(oper.getNumber());
    }

    private MathOper getVoidOper() {
        MathOper oper = new MathOper();
        oper.setNumber("");
        oper.setFunction("");
        return oper;
    }

    public MathOper getLastOper() {
        return this.lastOper;
    }
}
