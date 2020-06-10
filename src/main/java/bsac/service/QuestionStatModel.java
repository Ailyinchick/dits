package bsac.service;

public class QuestionStatModel {
    int questionId;
    String FIO;
    String testName;
    String questionDescription;
    int countAnswers;
    double questionRate;


    public QuestionStatModel(int countAnswers, double questionRate, String FIO, String testName, String questionDescription) {
        this.countAnswers = countAnswers;
        this.questionRate = questionRate;
        this.FIO = FIO;
        this.testName = testName;
        this.questionDescription = questionDescription;
    }

    public QuestionStatModel() {

    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    @Override
    public String toString() {
        return ", FIO='" + FIO + '\'' +
                ", testName='" + testName + '\'' +
                ", questionDescription='" + questionDescription + '\'' +
                "countAnswers=" + countAnswers +
                ", questionRate=" + questionRate +
                '}';
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getCountAnswers() {
        return countAnswers;
    }

    public void setCountAnswers(int countAnswers) {
        this.countAnswers = countAnswers;
    }

    public double getQuestionRate() {
        return questionRate;
    }

    public void setQuestionRate(double questionRate) {
        this.questionRate = questionRate;
    }
}
