package br.com.bsdev.PostNews.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(catalog = "postnews_dev", name = "Post")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private String pathImage;

    private Boolean isHighlight;

    private Date dtRegister;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public Boolean getHighlight() {
        return isHighlight;
    }

    public void setHighlight(Boolean highlight) {
        isHighlight = highlight;
    }

    public Date getDtRegister() {
        return dtRegister;
    }

    public void setDtRegister(Date dtRegister) {
        this.dtRegister = dtRegister;
    }
}
