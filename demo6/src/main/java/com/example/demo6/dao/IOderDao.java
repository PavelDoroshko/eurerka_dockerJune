package com.example.demo6.dao;

import com.example.demo6.model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOderDao extends JpaRepository<Oder,Long> {
}
