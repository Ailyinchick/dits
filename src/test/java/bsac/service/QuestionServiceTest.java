package bsac.service;


import bsac.config.HibernateConfig;
import bsac.config.WebConfig;
import bsac.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@ComponentScan(basePackages = "bsac")
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
@WebAppConfiguration
@PropertySource("classpath:db.properties")
@PropertySource(value = "classpath:hibernate.properties")
public class QuestionServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private QuestionService questionService;

    @Test
    public void showAll() {
        for (String str : questionService.getAnswersByQuestion(1)
        ) {
            System.out.println(str);
        }
    }

    @Test
    public void showAllQuestion() {
        for (Question q : questionService.getAllQuestions()
        ) {
            System.out.println(q);
        }

    }
    public void getQuestionById() {
        for (int i = 1; i <= questionService.questionRepository.findAll(Question.class, questionService.questionRepository.getBeanToBeAutowired()).size(); i++) {
            System.out.println(questionService.getQuestionById(i));
        }
    }

}
