package com.example.demo5.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name = "CommentFindWithJoinFetch", query = "select c FROM Comment c JOIN FETCH c.topic t")
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private  String text;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    private Topic topic;

    public Comment(String text) {
        this.text = text;
    }
}
