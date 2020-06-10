package bsac.service;


import bsac.dao.QuestionRepository;
import bsac.model.Answer;
import bsac.model.Question;
import bsac.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<String> getAnswersByQuestion(int questionId) {
        List<Question> questions = questionRepository.findAll(Question.class, questionRepository.getBeanToBeAutowired());
        List<String> str = new ArrayList<>();

        if (questionId >= 0 && questionId <= questions.size()) {
            for (Question question : questions) {
                if (question.getQuestionId() == questionId) {
                    for (Answer answer : question.getAnswers()
                    ) {
                        str.add(answer.getDescription());
                    }
                }
            }
        } else {
            System.out.println("Всё плохо, такой вопрос не найден");
        }
        return str;
    }

    public Question getQuestionById(int id) {
        Question question = new Question();
        List<Question> questions = questionRepository.findAll(Question.class, questionRepository.getBeanToBeAutowired());
        if (id >= 0 && id <= questions.size()) {
            for (Question quest : questions
            ) {
                if (quest.getQuestionId() == id) {
                    question = quest;
                }
            }
        } else {
            System.out.println("Всё плохо, вопроса в таким описанием нет в БД");
        }
        return question;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll(Question.class, questionRepository.getBeanToBeAutowired());
    }

    public List<String> getNamesQuestions() {
        List<String> namesTopics = new ArrayList<>();
        for (Question q : questionRepository.findAll(Question.class, questionRepository.getBeanToBeAutowired())
        ) {
            namesTopics.add(q.getDescription());
        }
        return namesTopics;
    }

    //public  ifExists
    public Question getQuestionByDescription(String nameQuestion, Test test) {
//        for (Question q : getAllQuestions()
//        ) {
//            if (nameQuestion.equals(q.getDescription())) {
//                return q;
//            }
//        }
        Question question = new Question();
        question.setDescription(nameQuestion);
        question.setTest(test);
        //question.setTest(test);
//        questionRepository.testingCreateMethod(question, questionRepository.getBeanToBeAutowired());
        questionRepository.create(question);
        return question;
    }


}
