package com.example.demo5.dao;

import com.example.demo5.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostDao extends JpaRepository<Post,Long> {
}
