package com.example.demo5.controller;

import com.example.demo5.model.Comment;
import com.example.demo5.service.N1service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/n1")
public class N1Controller {

   private final N1service n1service;

    public N1Controller(N1service n1service) {
        this.n1service = n1service;
    }


    @GetMapping("/add")
    public String add() {
      n1service.add();
      return "ok";
    }
    @GetMapping("/get")
    public int get() {
        return n1service.get();
    }
    @GetMapping("/getTopic")
    public String getTopic() {
        return n1service.getTopicByComment();
    }

    @GetMapping("/getJoinFetch")
    public List<Comment> getJoinFetch(){
        return n1service.findCommentWithJoinFetch();
    }
}
