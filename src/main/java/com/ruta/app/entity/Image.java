package com.ruta.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


}
