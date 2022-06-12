package com.psteide.colubridtrackerapi.feedings;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.psteide.colubridtrackerapi.snakes.Snake;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "feedings")
public class Feeding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "date")
    private String date;

    @Column(name = "item")
    private String item;

    @ManyToOne
    @JoinColumn(name = "snake_id")
    @JsonIgnore
    private Snake snake;
}