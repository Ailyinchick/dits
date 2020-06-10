package bsac.service;

import bsac.dao.QuestionRepository;
import bsac.dao.TestRepository;
import bsac.dao.TopicRepository;
import bsac.model.Question;
import bsac.model.Test;
import bsac.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateTopicTestQuestionService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TopicService topicService;

    @Autowired
    TestService testService;

    @Autowired
    QuestionService questionService;

    @Transactional
    public Question createNewQuestion(String nameTopic, String nameTest, String nameQuestion) {


        Topic topic = topicService.createTopicByName(nameTopic);

        Test test = testService.createTestByName(nameTest, topic);


        Question question = questionService.getQuestionByDescription(nameQuestion, test);
        return question;


    }

}








