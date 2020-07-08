package br.com.bsdev.PostNews.request;

import org.springframework.web.multipart.MultipartFile;

public class PostRequest {

    private String title;
    private String description;
    private MultipartFile file;
    private Boolean highlight;
    private Integer id;

    public PostRequest() {
    }

    public PostRequest(String title, String description, MultipartFile file, Boolean highlight) {
        this.title = title;
        this.description = description;
        this.file = file;
        this.highlight = highlight;
    }

    public PostRequest(String title, String description, MultipartFile file, Boolean highlight, Integer id) {
        this.title = title;
        this.description = description;
        this.file = file;
        this.highlight = highlight;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Boolean getHighlight() {
        return highlight;
    }

    public void setHighlight(Boolean highlight) {
        this.highlight = highlight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
