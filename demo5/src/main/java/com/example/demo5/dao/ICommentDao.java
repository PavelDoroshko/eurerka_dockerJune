package com.example.demo5.dao;

;
import com.example.demo5.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentDao extends JpaRepository<Comment, Long> {
}
