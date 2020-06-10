package bsac.controller.admin;


import bsac.model.User;
import bsac.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminCreateUserController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping("/createUser")
    public String addUser(Model model, User user, String nameRole) {
        createUserService.сreateUser(user, nameRole);
        user = new User();
        model.addAttribute("user", user);
        model.addAttribute("allRoles", CreateUserService.getAllRoles());
        model.addAttribute("success", "Пользователь добавлен");
        return "Admin/createUser";
    }

    @GetMapping(value = "/createUser")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("allRoles", CreateUserService.getAllRoles());
        return "Admin/createUser";
    }


}
