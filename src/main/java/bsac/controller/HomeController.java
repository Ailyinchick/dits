package bsac.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {


    @GetMapping(value = "/")
    public String homePage() {
        return "login";
    }

    @GetMapping(value = "/admin")
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "Admin/admin";
    }

    @GetMapping(value = "/user")
    public String userPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "User/user";
    }

    @GetMapping(value = "/tutor")
    public String tutorPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "Tutor/tutor";
    }

    @GetMapping(value = "/Access_Denied")
    public String accessDenied(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "Access_Denied";
    }

    @GetMapping(value = "/accessDenied")
    public String anotherDenied(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "Access_Denied";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    static String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
