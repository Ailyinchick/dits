package bsac.controller.user;


import bsac.model.Question;
import bsac.model.Statistic;
import bsac.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class TestPageController {

    @Autowired
    UserService userService;

    @Autowired
    TestService testService;

    @Autowired
    QuestionService questionService;

    @Autowired
    StatisticService statisticService;

    @Autowired
    AnswerService answerService;

    private static List<Question> questionList;
    private static int max;
    private static int counter;

    @GetMapping(value = "/goTest")
    public String goTest(@RequestParam String testName, ModelMap modelMap) {
        statisticService.statList = new LinkedHashMap<>();
        questionList = testService.getQuestionsByTest(testName);
        max = questionList.size();
        counter = 0;

        modelMap.addAttribute("question", questionList.get(counter).getDescription());
        modelMap.addAttribute("answers", questionService.getAnswersByQuestion(questionList.get(counter).getQuestionId()));
        counter++;
        return "User/testPage";
    }

    @GetMapping(value = "/nextTestPage")
    public String nextTestPage1(@RequestParam(value = "choosenAns") String choosenAnswer, ModelMap modelMap) {
        if (counter < max) {
            statisticService.statList.put(questionList.get(counter - 1).getDescription(), configureStatistic(choosenAnswer));
            modelMap.addAttribute("question", questionList.get(counter).getDescription());
            modelMap.addAttribute("answers", questionService.getAnswersByQuestion(questionList.get(counter).getQuestionId()));
            counter++;
            return "User/testPage";
        } else
            return resultPageFill(choosenAnswer, modelMap);
    }

    @GetMapping(value = "/resultPage")
    public String resultPageFill(String choosenAnswer, ModelMap modelMap) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String endTest = formatter.format(new Date());
        statisticService.statList.put(questionList.get(counter - 1).getDescription(), configureStatistic(choosenAnswer));
        statisticService.saveMapOfStat(statisticService.statList, endTest);
        modelMap.addAttribute("statistic", statisticService.selectUserTestStatistic(
                "" + userService.getUserByUsername(getPrincipal()).getUserId(),
                "" + endTest,
                "" + endTest
        ));
        return "User/resultPage";
    }

    private Statistic configureStatistic(String choosenAns) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Statistic statistic = new Statistic();
        statistic.setCorrect(answerService.getAnswerByDescription(choosenAns).ifCorrect());
        statistic.setDate(formatter.format(new Date()));
        statistic.setQuestion(questionList.get(counter - 1));
        statistic.setUser(userService.getUserByUsername(getPrincipal()));
        return statistic;
    }

    private static String getPrincipal() {
        String userName = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
