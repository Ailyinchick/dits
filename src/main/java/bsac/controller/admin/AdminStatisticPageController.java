package bsac.controller.admin;

import bsac.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class AdminStatisticPageController {

    @Autowired
    ViewStatisticService viewStatisticService;

    @Autowired
    StatisticService statisticService;


    @GetMapping("/statisticByQuestion")
    public String viewStatisticQuestion(ModelMap modelMap) {
        List<ViewStatistic> statisticByQuestionList = viewStatisticService.getQuestionStatisticList();
//            Collections.sort(varList, new SortByQuestionId());
        modelMap.addAttribute("statisticList", statisticByQuestionList);
        return "Admin/statisticByQuestion";
    }

    @GetMapping("/statisticByTest")
    public String viewStatisticTest(ModelMap modelMap) {
        List<ViewStatistic> statisticByTestList = viewStatisticService.getTestStatisticList();
        modelMap.addAttribute("statisticList", statisticByTestList);
        return "Admin/statisticByTest";
    }


    @GetMapping(value = "/statisticEveryUser")
    public String resultPageFill(ModelMap modelMap) {

        List<ViewStatistic> varList = viewStatisticService.getUserTestStatisticList();

        //List<QuestionStatModel> varList = statisticService.getStatList(userService.getUserByUsername(getPrincipal()).getUserId());
        //varList.sort(Comparator.comparing(QuestionStatModel::getFIO));
        modelMap.addAttribute("statistic", varList);
        return "Admin/statisticEveryUser";
    }


}
