package bsac.model;

import javax.persistence.*;

@Entity
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statisticId;
    private String date;
    private int correct;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId")
    private Question question;


    @Override
    public String toString() {
        return "Statistic{" +
                "statisticId=" + statisticId +
                ", date='" + date + '\'' +
                ", correct=" + correct +
                ", user=" + user.getLogin() +
                ", question=" + question.getDescription() +
                '}';
    }

    public Statistic(String date, int correct, User user, Question question) {
        this.date = date;
        this.correct = correct;
        this.user = user;
        this.question = question;
    }

    public Statistic() {
    }

    public int getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(int statisticId) {
        this.statisticId = statisticId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect(int correct) {
        if (correct == 1) {
            return true;
        } else return false;
    }

    public static class Builder {
        private Statistic statistic;

        public Builder() {
            statistic = new Statistic();
        }

        public Builder withDate(String date) {
            statistic.date = date;
            return this;
        }

        public Builder withId(int id) {
            statistic.statisticId = id;
            return this;
        }

        public Builder withCorrect(int correct) {
            statistic.correct = correct;
            return this;
        }

        public Builder withQuestion(Question question) {
            statistic.question = question;
            return this;
        }

        public Builder withUser(User user) {
            statistic.user = user;
            return this;
        }

        public Statistic create() {
            return statistic;
        }
    }
}