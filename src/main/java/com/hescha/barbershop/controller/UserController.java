package com.hescha.barbershop.controller;

import java.security.Principal;
import java.util.List;

import com.hescha.barbershop.entity.User;
import com.hescha.barbershop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping
    String get(Model model) {
        List<User> list = service.repository.findAll();
        model.addAttribute("list", list);
        return "user-list";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String edit(Model model, @PathVariable(required =
            false) Long id) {
        if (id != null) {
            User entity = service.read(id);
            model.addAttribute("entity", entity);
        } else {
            model.addAttribute("entity", new User());
        }
        return "user-add-edit";
    }

    @PostMapping("/create")
    public String createOrUpdate(User entity) throws Exception {
        if (entity.getId() == null)
            service.userRegistration(entity);
        else {
            User read = service.read(entity.getId());
            read.setDateBorn(entity.getDateBorn());
            read.setEmail(entity.getEmail());
            read.setFio(entity.getFio());
            read.setPhone(entity.getPhone());
            read.setPassword(passwordEncoder.encode(entity.getPassword()));
            service.update(read);
        }
        return "redirect:/user";
    }

    @Controller
    public class LoginController {
        @GetMapping("/login")
        public String login(@RequestParam(value = "error", required = false) String error, Model model) {
            if (error != null) {
                model.addAttribute("error", "true");
            }
            return "login";
        }
    }    

        @RequestMapping(path = "/delete/{id}")
        public String delete(Model model, @PathVariable Long id) throws Exception {
            service.delete(id);
            return "redirect:/user";
        }

        @RequestMapping(path = "/history")
        public String history(Model model, Principal principal) {
            User user = service.findByUsername(principal.getName());
            model.addAttribute("list", user.getOrders());
            return "history";
        }
}
