package com.psteide.colubridtrackerapi.snakes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "snakes")
public class Snake {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "name")
    private String name;

    @Column(name = "breeder_id")
    private String breederId;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "gender")
    private String gender;

    @Column(name = "last_meal")
    private String lastMeal;

    @Column(name = "last_note")
    private String lastNote;
}