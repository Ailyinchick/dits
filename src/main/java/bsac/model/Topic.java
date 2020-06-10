package bsac.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int topicId;

    @Column
    private String description;

    @Column
    private String name;

    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Test> tests;


    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", tests=" + tests +
                '}';
    }

    public Topic() {
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}
