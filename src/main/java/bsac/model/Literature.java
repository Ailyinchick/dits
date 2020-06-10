package bsac.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int literatureId;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId")
    private Question question;

    @OneToMany(mappedBy = "literature", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Link> links;


    @Override
    public String toString() {
        return "Literature{" +
                "literatureId=" + literatureId +
                ", description='" + description + '\'' +
                ", question=" + question.getDescription() +
                ", links=" + links +
                '}';
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Literature(String description, Question question) {
        this.description = description;
        this.question = question;
    }

    public String getCasualLinks() {
        String str = "";
        for (Link l : links
        ) {
            str += l.getLink() + "\n";
        }
        return str;
    }

    public Literature() {
    }

    public int getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(int literatureId) {
        this.literatureId = literatureId;
    }

    String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
