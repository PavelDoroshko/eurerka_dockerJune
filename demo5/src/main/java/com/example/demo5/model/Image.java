package com.example.demo5.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String url;
    @ManyToOne
    private Post post;
    public Image(String url){
        this.url=url;
    }
}
