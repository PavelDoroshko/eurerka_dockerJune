package com.example.demo6.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@Entity
public class Oder implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private long id;
        private  int price;
        private String name;

}
