package com.example.demo4.dao;

import com.example.demo4.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalDao  extends JpaRepository<Animal, Long> {
}
