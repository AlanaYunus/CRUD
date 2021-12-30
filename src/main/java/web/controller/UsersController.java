package web.controller;

import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import hiber.model.User;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String allUsers(ModelMap model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/{id}")
    public String getById(ModelMap model, @PathVariable("id") int id) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "show";
    }

    @GetMapping("/add")
    public String newPerson(ModelMap model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping(value = "/add")
    public String add(@ModelAttribute("user") User user) {
        userService.add(user);
        return "successPage";
    }


    @GetMapping(value = "/edit/{id}")
    public String edit(ModelMap model, @PathVariable("id") int id) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "successPage";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "successPage";
    }

}