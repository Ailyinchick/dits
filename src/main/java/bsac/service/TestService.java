package bsac.service;

import bsac.dao.TestRepository;
import bsac.model.Question;
import bsac.model.Test;
import bsac.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;


    public Test getTestByName(String testName) {
        List<Test> testList = testRepository.findAll(Test.class, testRepository.getBeanToBeAutowired());
        Test outTest = new Test();
        if (testList.toString().contains(testName)) {
            for (Test test : testList
            ) {
                if (test.getName().equals(testName)) {
                    outTest = test;
                }
            }
        } else {
            System.out.println("Всё плохо, такого теста нет");
        }
        return outTest;
    }

    public List<Question> getQuestionsByTest(String testName) {
        List<Test> tests = testRepository.findAll(Test.class, testRepository.getBeanToBeAutowired());
        List<Question> str = new ArrayList<>();

        if (tests.toString().contains(testName)) {
            for (Test test : tests) {
                if (test.getName().equals(testName)) {
                    for (Question question : test.getQuestions()
                    ) {
                        str.add(question);
                    }
                }
            }
        } else {
            System.out.println("Всё плохо, такой тест не найден");
        }
        return str;
    }

    public List<String> getNamesTests(){
        List<String> namesTopics = new ArrayList<>();
        for (Test t : testRepository.findAll(Test.class, testRepository.getBeanToBeAutowired())
        ) {
            namesTopics.add(t.getName());
        }
        return namesTopics;
    }


    public List<Test> getAllTests() {
        return testRepository.findAll(Test.class, testRepository.getBeanToBeAutowired());
    }

    public Test getTest(String nameTest, Topic topic) {
//        Test result = null;
        for (Test t : getAllTests()
        ) {
            if (nameTest.equals(t.getName())) {
                //добавить к тесту топик, возможно новый


                return t;
//                result.setTestId(t.getTestId());
//                result.setTopic(topic);
//                result.setName(t.getName());
//                result.setDescription(t.getDescription());
//                result = t;
//                break;
            }
        }
//        if (result == null) {
            Test test = new Test();
            test.setName(nameTest);
            test.setTopic(topic);
            testRepository.testingCreateMethod(test, testRepository.getBeanToBeAutowired());
            return test;
//            result = test;
//        }
//        return result;
    }

    public Test createTestByName(String nameTest, Topic topic){
        Test newTest = new Test();
        for (Test t : getAllTests()
        ) {
            if (nameTest.equals(t.getName())) {
                newTest.setTestId(t.getTestId());
                newTest.setDescription(t.getDescription());
                newTest.setName(t.getName());
                newTest.setTopic(topic);
                return newTest;
            }
        }
        newTest.setName(nameTest);
        newTest.setDescription(nameTest);
        newTest.setTopic(topic);
        testRepository.create(newTest);
        return newTest;
    }


}
