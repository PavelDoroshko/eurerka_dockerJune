package com.example.demo4.model;

import org.apache.poi.ss.formula.functions.T;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
public  static  final  int NUM = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long animalId;
    private String name;
    private LocalDate day;

    static void method (T a){}

    public Animal(long animalId, String name, LocalDate day) {
        this.animalId = animalId;
        this.name = name;
        this.day = day;
    }

    public Animal() {

    }
    public Animal(long animalId) {
        this.animalId = animalId;
    }
     long getAnimalId() {
        return this.animalId;
    }


    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
