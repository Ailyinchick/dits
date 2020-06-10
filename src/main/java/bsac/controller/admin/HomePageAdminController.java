package bsac.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageAdminController {


    @GetMapping(value = "/adminStatistic")
    public String showStatisticPage() {
        return "Admin/adminStatistic";
    }

    @GetMapping(value = "/goHomeAdmin")
    public String goHomeAdmin() {
        return "Admin/admin";
    }

}
