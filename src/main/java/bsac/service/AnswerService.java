package bsac.service;

import bsac.dao.AnswerRepository;
import bsac.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {


    @Autowired
    AnswerRepository answerRepository;


    public Answer getAnswerByDescription(String ansDescrip) {
        List<Answer> answerList = answerRepository.findAll(Answer.class, answerRepository.getBeanToBeAutowired());
        Answer answer = new Answer();
        if (answerList.toString().contains(ansDescrip)) {
            for (Answer var : answerList
            ) {
                if (var.getDescription().equals(ansDescrip)) {
                    answer = var;
                }
            }
        } else {
            System.out.println("Всё плохо. Такого варианта ответа не найдено в БД");
        }
        return answer;
    }

}
