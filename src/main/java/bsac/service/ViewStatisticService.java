package bsac.service;

import bsac.dao.QuestionRepository;
import bsac.model.Question;
import bsac.model.Statistic;
import bsac.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ViewStatisticService {


    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TestService testService;

    @Autowired
    StatisticService statisticService;

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;


    private ViewStatistic getQuestionInfo(Question question) {
        ViewStatistic viewStatistic;

        //вынестив в отдельный метод
        List<Statistic> statisticList = statisticService.getFilteredStatisticByQuestionId(question.getQuestionId());// statisticRepository.findAll(Statistic.class, statisticRepository.getBeanToBeAutowired()) ;
        //get list by currently question
        if (!statisticList.isEmpty()) {
            int numberOfTimes = statisticList.size();
            //count all times to answer the question
            int countOfCorrectAnswers = 0;
            //count correct times to answer the question
            for (Statistic statistic : statisticList) {
                if (statistic.isCorrect(statistic.getCorrect())) {
                    countOfCorrectAnswers++;
                }
            }
            viewStatistic = new ViewStatistic(
                    question.getDescription(),
                    numberOfTimes,
                    //вынести в отдельный метод процент правильных ответов
                    (int) Math.round(((double) countOfCorrectAnswers) / numberOfTimes * 100));
        } else {
            viewStatistic = null;
        }
        return viewStatistic;
    }

    public List<ViewStatistic> getQuestionStatisticList() {
        List<ViewStatistic> questionInfoList = new ArrayList<>();
        ViewStatistic viewStatistic;
        List<Question> questionList = questionService.getAllQuestions();  //  .findAll(Question.class, questionRepository.getBeanToBeAutowired());
        for (Question question : questionList) {
            viewStatistic = getQuestionInfo(question);
            if (viewStatistic != null) {
                questionInfoList.add(viewStatistic);
            }
        }
        // сортировка списка по названию вопроса
        questionInfoList.sort(Comparator.comparing(ViewStatistic::getName));
        return questionInfoList;
    }

    private ViewStatistic getTestInfo(Test test) {
        ViewStatistic viewStatistic;
        //получаем статистику, которая относится непосредственно к нашему тесту (текущему, который передали)
        List<Statistic> statisticList = statisticService.getFilteredStatisticByTestId(test.getTestId());// statisticRepository.findAll(Statistic.class, statisticRepository.getBeanToBeAutowired()) ;
        if (!statisticList.isEmpty()) {
            int numberOfQuestionInTest = test.getQuestions().size();
            //количество записей в статистике эквивалентно количеству ответов на вопросы, которые задействованы в данном тесте
            int numberOfTimes = statisticList.size();

            //создаем запись для представления
            viewStatistic = new ViewStatistic(
                    test.getName(),
                    numberOfTimes/ numberOfQuestionInTest,
                    calculatePercentage(statisticList));
        } else {
            //возвращаем null в случаем если статистика пуста
            viewStatistic = null;
        }
        return viewStatistic;
    }

        public List<ViewStatistic> getTestStatisticList() {
            List<ViewStatistic> testInfoList = new ArrayList<>();
            ViewStatistic viewStatistic;
            //получаем весь список вопросов
            List<Test> testList = testService.getAllTests();
            for (Test test : testList) {
                //получаем информацию в удобном для нас представленнии по каждому из тестов
                viewStatistic = getTestInfo(test);
                if (viewStatistic != null) {
                    //если в таблице статистики есть записи по этому тесту, то добавляем егов наш результирующий список
                    testInfoList.add(viewStatistic);
                }
            }
            // сортировка списка по названию теста
            testInfoList.sort(Comparator.comparing(ViewStatistic::getName));
            return testInfoList;
        }

    private ViewStatistic getUserTestInfo(Statistic statistic) {

        ViewStatistic viewStatistic;

        List<Statistic> statisticList = statisticService.getFilteredStatisticByTestUser(statistic);

        if (!statisticList.isEmpty()) {

            //посчитать сколько раз проходил данный тест данный пользователь
            int countTimesCompletedTest = countUserCompletedTest(statistic);


            viewStatistic = new ViewStatistic(
                    statistic.getUser().getFIO(),
                    statistic.getQuestion().getTest().getName(),
                    countTimesCompletedTest,
                    //процент правильных ответов
                    calculatePercentage(statisticList)
            );

        } else {
            viewStatistic = null;
        }
        return viewStatistic;


    }

    private int countUserCompletedTest(Statistic statistic) {

        int count = 0;
        List<Statistic> statisticList = statisticService.getFilteredStatisticByTestId(statistic.getQuestion().getTest().getTestId());
        for (Statistic s : statisticList) {
            if (statistic.getUser().getUserId() == s.getUser().getUserId()) {
                count++;
            }
        }
//        List<Statistic> statisticList = statisticService.getFilteredStatisticByTestUser(statistic);
//        statisticList.removeIf( s -> s.getQuestion().getTest().getName() != statistic.getQuestion().getTest().getName()  );;
//        count = statisticList.size();
        return count;
    }


    private int countCorrectAnswer(Statistic statistic) {
        int count = 0;
        List<Statistic> statisticList = statisticService.getFilteredStatisticByTestUser(statistic);

        for (Statistic s : statisticList) {
            if (s.getCorrect() == 1) {
                count++;
            }
        }

        return count;
    }

    public int calculatePercentage(List<Statistic> statisticList){

        int countOfTrueAnswers = 0;
        double countQuestions = statisticList.size();

        for (Statistic statistic : statisticList){
            if (statistic.getCorrect() == 1) countOfTrueAnswers++;
        }
        return  (int) Math.round(countOfTrueAnswers / countQuestions * 100);
    }


//    private int countAllAnswer(Statistic statistic) {
//
//        List<Statistic> statisticListTestId = statisticService.getFilteredStatisticByTestId(statistic.getQuestion().getTest().getTestId());
//        List<Statistic> statisticListUserId = statisticService.getFilteredStatisticByUserId(statistic.getUser().getUserId(), statisticListTestId);
//        //statisticService.getAllStatisticByTestId(statistic.getQuestion().getTest().getTestId());
//
//        return statisticListUserId.size();
//    }

    public List<ViewStatistic> getUserTestStatisticList() {

        //создадим пустой спискок, в который будем добавлять представления
        List<ViewStatistic> userTestInfoList = new ArrayList<>();
        //объявим класс пледставления статистики
        ViewStatistic viewStatistic;
        //возьмём выборку всей статистики
        List<Statistic> statisticList = statisticService.findAll();
        for (Statistic statistic : statisticList) {
            //получим по текущей статистике представление
            viewStatistic = getUserTestInfo(statistic);
            if (viewStatistic != null) {
                userTestInfoList.add(viewStatistic);
            }
        }
        //добавим результирующий список в Set для исключения повторений
        Set<ViewStatistic> set = new HashSet<>(userTestInfoList);
        userTestInfoList.clear();
        userTestInfoList.addAll(set);
        // сортировка списка по названию FIO
        userTestInfoList.sort(Comparator.comparing(ViewStatistic::getFIO));

        return userTestInfoList;
    }


}
