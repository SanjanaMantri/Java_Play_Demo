package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer Id;

    @Basic
    @JsonProperty("title")
    private String title;

    public Book(Integer Id,String Title) {

        this.Id=Id;
        this.title =Title;

    }

    public Book() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return title;

    }

    public void setTitle(String Title) {
        this.title = Title;
    }

}
