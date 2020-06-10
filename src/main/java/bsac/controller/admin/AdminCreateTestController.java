package bsac.controller.admin;


import bsac.dao.QuestionRepository;
import bsac.model.Question;
import bsac.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class AdminCreateTestController {

    @Autowired
    TopicService topicService;

    @Autowired
    TestService testService;

    @Autowired
    QuestionService questionService;



    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    CreateTopicTestQuestionService ttqService;

    @GetMapping("/saveNewQuestion")
    public String addTest( @RequestParam(name = "topic") String nameTopic,
                           @RequestParam(name = "test") String nameTest,
                           @RequestParam(name = "question") String nameQuestion,
                           Model model){

        Question completed = ttqService.createNewQuestion(nameTopic, nameTest, nameQuestion);

        List <String> nameTopics = topicService.getNamesTopics();
        List <String> nameTests = testService.getNamesTests();
        List <String> nameQuestions = questionService.getNamesQuestions();
        model.addAttribute("topics", nameTopics);
        model.addAttribute("tests", nameTests );
        model.addAttribute("questions", nameQuestions);
        model.addAttribute("success", "Добавлен вопрос" + completed.toString() );
        return "Admin/createTest";
    }


        @GetMapping("/createTest")
        public String createTest(Model model){
            model.addAttribute("topics", topicService.getNamesTopics());
            model.addAttribute("tests", testService.getNamesTests() );
            model.addAttribute("questions", questionService.getNamesQuestions());
            return "Admin/createTest";
        }




}
