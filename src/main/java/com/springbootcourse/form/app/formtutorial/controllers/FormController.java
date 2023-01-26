package com.springbootcourse.form.app.formtutorial.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootcourse.form.app.formtutorial.models.User;

@Controller
@RequestMapping("/form")
public class FormController {

  @GetMapping
  public String form(Model model) {
    User user = new User();
    model.addAttribute("title", "user FOrms");
    model.addAttribute("user", user);
    return "form";
  }

  @PostMapping
  public String processForm(Model model,
                            @RequestParam String username,
                            @RequestParam String password,
                            @RequestParam String email) {
    
    User user = new User(username, password, email);
    model.addAttribute("title", "Form");
    model.addAttribute("user", user);

    return "result";
  }

  // Otra forma de hacerlo
  // Esto funcionara siempre y cuando los parametros del formulario tengan el mismo nombre
  // que los atributos de user
  @PostMapping("/result2")
  public String processFormUserAsParameter(@Valid User user, BindingResult result, Model model) {

    // Comprobamos los errores producidosd de la validacion del formulario 
    // mapeado en el objeto User.
    if (result.hasErrors()) {
      /* 
      Map<String, String> errors = new HashMap<>();
      result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
      model.addAttribute("errors", errors);
      */
      
      return "form";
    }

    model.addAttribute("title", "Form");
    model.addAttribute("user", user);

    return "result2";
  }

}
