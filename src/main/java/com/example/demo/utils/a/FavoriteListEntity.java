package com.example.demo.utils.a;

import javax.persistence.*;

@Entity
@Table(name = "favorite_lists")
public class FavoriteListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String description;

    @Column
    private int idDiary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdDiary() {
        return idDiary;
    }

    public void setIdDiary(int idDiary) {
        this.idDiary = idDiary;
    }
}
