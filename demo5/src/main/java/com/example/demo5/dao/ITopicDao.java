package com.example.demo5.dao;

import com.example.demo5.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicDao extends JpaRepository<Topic, Long> {
}
