package com.emjey.practice.validation;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute(new User());
        return "sign-up";
    }

    @GetMapping("result")
    public String getResult() {
        return "result";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid User user, BindingResult result) {
        System.out.println("Has errors? : " + result.hasErrors());

      if (user.getFirstName().equals(user.getLastName()))
        result.rejectValue("lastName" ,"","Please enter valid data");
        if (result.hasErrors()) return "sign-up";

        return "redirect:/result";
    }
}
