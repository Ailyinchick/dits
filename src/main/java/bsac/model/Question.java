package bsac.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int questionId;

    @Column
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "testId")
    private Test test;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Answer> answers;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Statistic> statisticList;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Literature> literatureList;

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", description='" + description + '\'' +
                ", test=" + test.getName() +
                ", answers=" + answers +
                '}';
    }

    public Question() {
    }

    public String getLiteratures() {
        String str = "";
        for (Literature l : getLiteratureList()
        ) {
            str += l.getDescription() + "\n";
        }
        return str;
    }

    public List<Statistic> getStatisticList() {
        return statisticList;
    }

    public void setStatisticList(List<Statistic> statisticList) {
        this.statisticList = statisticList;
    }

    public List<Literature> getLiteratureList() {
        return literatureList;
    }

    public void setLiteratureList(List<Literature> literatureList) {
        this.literatureList = literatureList;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
