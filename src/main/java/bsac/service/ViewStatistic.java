package bsac.service;

import java.util.Objects;

public class ViewStatistic {

    private String FIO;

    private String name;
    private int countCompleted;
    private int percent;

    public ViewStatistic() {
    }

    public ViewStatistic(String name, int countCompleted, int percent) {
        this.name = name;
        this.countCompleted = countCompleted;
        this.percent = percent;
    }

    public ViewStatistic(String FIO, String name, int countCompleted, int percent) {
        this.FIO = FIO;
        this.name = name;
        this.countCompleted = countCompleted;
        this.percent = percent;
    }

    public ViewStatistic(String FIO, ViewStatistic viewStatistic) {
        this.FIO = FIO;
        this.name = viewStatistic.name;
        this.countCompleted = viewStatistic.countCompleted;
        this.percent = viewStatistic.percent;
    }



    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountCompleted() {
        return countCompleted;
    }

    public void setCountCompleted(int countCompleted) {
        this.countCompleted = countCompleted;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "StatisticByQuestion{" +
                "questionDescription='" + name + '\'' +
                ", countCompleted=" + countCompleted +
                ", percent=" + percent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewStatistic that = (ViewStatistic) o;
        return countCompleted == that.countCompleted &&
                percent == that.percent &&
                Objects.equals(FIO, that.FIO) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIO, name, countCompleted, percent);
    }
}
