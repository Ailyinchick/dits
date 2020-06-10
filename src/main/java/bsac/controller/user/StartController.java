package bsac.controller.user;


import bsac.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @Autowired
    TopicService topicService;

    @GetMapping(value = "/chooseTest")
    public String ChooseTest(ModelMap modelMap) {
        modelMap.addAttribute("topic", topicService.getTopics());
        return "User/UserChoose";
    }

}