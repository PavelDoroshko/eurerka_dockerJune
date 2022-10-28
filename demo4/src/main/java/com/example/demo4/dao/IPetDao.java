package com.example.demo4.dao;

import com.example.demo4.model.Animal;
import com.example.demo4.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetDao extends JpaRepository<Pet, Long> {
}
