package com.example.demo4.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "petId")
public class Pet extends Animal {
    public  static  final  int NUM = 1;
    private String name;
    private  int age;
//    private LocalDate dayFrom;
//    private  LocalDate dayTo;
    private  LocalDate day;

       long getAnimalId() {
        return 2;
    }
//    @Override
//    public LocalDate getDay() {
//        return day;
//    }
//
//    @Override
//    public void setDay(LocalDate day) {
//        this.day = day;
//    }
//
//    public Pet(long animalId, String name, LocalDate day, String name1, int age, LocalDate day1) {
//        super(animalId, name, day);
//        this.name = name1;
//        this.age = age;
//        this.day = day1;
//    }
////    public Pet(long animalId, String name, LocalDate day, String name1, int age, LocalDate dayFrom, LocalDate dayTo) {
////        super(animalId, name, day);
////        this.name = name1;
////        this.age = age;
////        this.dayFrom = dayFrom;
////        this.dayTo = dayTo;
////    }
//
////    public LocalDate getDayFrom() {
////        return dayFrom;
////    }
////
////    public void setDayFrom(LocalDate dayFrom) {
////        this.dayFrom = dayFrom;
////    }
////
////    public LocalDate getDayTo() {
////        return dayTo;
////    }
////
////    public void setDayTo(LocalDate dayTo) {
////        this.dayTo = dayTo;
////    }
//
//
//
//    public Pet(long animalId, String name, int age) {
//        super(animalId);
//        this.name = name;
//        this.age = age;
//    }
//
//    public Pet(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public Pet() {
//
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Pet(String name) {
//        this.name = name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}
