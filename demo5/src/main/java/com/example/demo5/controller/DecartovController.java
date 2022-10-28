package com.example.demo5.controller;

import com.example.demo5.model.Comment;
import com.example.demo5.service.DecartovService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/decart")
public class DecartovController {

    private final DecartovService decartovService;


    public DecartovController(DecartovService decartovService) {
        this.decartovService = decartovService;
    }

        @GetMapping("/add")
        public String add() {
            decartovService.add();
            return "ok";
        }
    @GetMapping("/getPost")
    public void getJoinFetch(){
       decartovService.getPost();
    }
    @GetMapping("/findPost")
    public void findPost(){
        decartovService.find();
    }
    }

