package ru.bagautdinov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bagautdinov.exceptinos.UserNotFoundException;
import ru.bagautdinov.forms.MathOperForm;
import ru.bagautdinov.forms.mappers.MathOperFormMapper;
import ru.bagautdinov.models.MathOper;
import ru.bagautdinov.models.User;
import ru.bagautdinov.repository.UserRepository;
import ru.bagautdinov.services.MathOperService;

import javax.validation.Valid;

@Controller
public class CalcController {
    @Autowired
    private MathOperService mathService;

    @Autowired
    private UserRepository userRepository;


    @Secured("hasRole('ROLE_USER')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("mathOperForm", new MathOperForm());
        User user = null;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (ClassCastException e) {
            return "redirect:/login";
        }
        model.addAttribute("user_details", user);
        return "math";
    }

    @Secured("hasRole('ROLE_USER')")
    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public String calc(@ModelAttribute("mathOperForm") @Valid MathOperForm mathOperationForm,
                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "math";
        }
        User owner = null;
        try {
            owner = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (ClassCastException e) {
            throw new UserNotFoundException();
        }

        MathOper mathOper = MathOperFormMapper.transform(mathOperationForm);
        mathService.saveNewOper(owner, mathOper);

        String calc_result = mathService.doMath(mathOper).getNumber();

        model.addAttribute("result", calc_result);

        model.addAttribute("user_details", owner);
        return "math";
    }


    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(ModelMap model) {
        model.addAttribute("error", "User not found!");
        return "error";
    }
}
