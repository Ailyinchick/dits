package bsac.model;


import javax.persistence.*;

@Entity
public class Link {

    @Id
    @GeneratedValue
    private int linkId;
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "literatureId")
    private Literature literature;


    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", link='" + link + '\'' +
                ", literature=" + literature.getDescription() +
                '}';
    }

    public Link(String link, Literature literature) {
        this.link = link;
        this.literature = literature;
    }

    public Link() {
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Literature getLiterature() {
        return literature;
    }

    public void setLiterature(Literature literature) {
        this.literature = literature;
    }
}
