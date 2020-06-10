package bsac.service;

import bsac.dao.TopicRepository;
import bsac.model.Test;
import bsac.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getTopics() {
        return topicRepository.findAll(Topic.class, topicRepository.getBeanToBeAutowired());
    }

    public List<String> getTestsByTopic(String topicName) {
        List<String> str = new ArrayList<>();
        if (topicRepository.findAll(Topic.class, topicRepository.getBeanToBeAutowired()).toString().contains(topicName)) {
            for (Topic topic : topicRepository.findAll(Topic.class, topicRepository.getBeanToBeAutowired())
            ) {
                if (topic.getName().equals(topicName)) {
                    for (Test test : topic.getTests()
                    ) {
                        str.add(test.getName());
                    }
                }
            }
        } else {
            System.out.println("Всё плохо, такой топик не найден");
        }
        return str;
    }

    public List<String> getNamesTopics() {
        List<String> namesTopicsL = new ArrayList<>();

        for (Topic t : topicRepository.findAll(Topic.class, topicRepository.getBeanToBeAutowired())
        ) {
            namesTopicsL.add(t.getName());
        }

        return namesTopicsL;
    }

    public Topic getTopicByName(String nameTopic) {

        for (Topic t : getTopics()
        ) {
            if (nameTopic.equals(t.getName())) {
//                result.setName(t.getName());
//                result.setDescription(t.getDescription());
//                result.setTopicId(t.getTopicId());
                return t;
//                result = new Topic(t);
                //result.setTests(null);

//                break;
            }
        }

        Topic topic = new Topic();
        topic.setName(nameTopic);
        topicRepository.create(topic);

        return topic;
    }

    public Topic createTopicByName(String nameTopic) {
        Topic newTopic = new Topic();
        for (Topic t : getTopics()
        ) {
            if (nameTopic.equals(t.getName())) {
                newTopic.setTopicId(t.getTopicId());
                newTopic.setName(t.getName());
                newTopic.setDescription(t.getDescription());
                return newTopic;
            }
        }
        newTopic.setName(nameTopic);
        newTopic.setDescription(nameTopic);
        topicRepository.create(newTopic);
        return newTopic;


    }

}
