package bsac.controller.user;


import bsac.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChooseController {

    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/UserChoose", method = RequestMethod.GET)
    @ResponseBody
    public List<String> l(@RequestParam(value = "topic", required = false) String topic) {
        System.out.println(topic);
        return topicService.getTestsByTopic(topic);
    }


    @RequestMapping(value = "/ajaxURL", method = RequestMethod.GET)
    @ResponseBody
    public String cacheHandler() {
        System.out.println("Hello");
        return null;
    }

}