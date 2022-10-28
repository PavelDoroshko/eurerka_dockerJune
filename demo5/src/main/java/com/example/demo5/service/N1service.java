package com.example.demo5.service;


import com.example.demo5.dao.ICommentDao;
import com.example.demo5.dao.ITopicDao;
import com.example.demo5.model.Comment;
import com.example.demo5.model.Topic;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Service
@RequiredArgsConstructor
public class N1service {
    private final ITopicDao iTopicDao;
    private final ICommentDao iCommentDao;

    @PersistenceContext
    EntityManager entityManager;

    public void add() {
        for (int i = 0; i < 5; i++) {
            Topic topic = new Topic("topic" + i);

            Comment comment = new Comment("comment" + i);
            comment.setTopic(topic);
            iCommentDao.save(comment);
            iTopicDao.save(topic);
        }
    }

    public int get() {
        List<Comment> comments = iCommentDao.findAll();
        return comments.size();
    }

    public String getTopicByComment() {
        //List<Comment> comments = iCommentDao.findAll();
        List<Comment> comments = findCommentWithJoinFetch();
        for (int i = 0; i < comments.size(); i++) {
            System.out.println(comments.get(i).getTopic());
        }
            return "ok";

    }

    public List<Comment> findCommentWithJoinFetch(){
        Query query1 = entityManager.createNamedQuery("CommentFindWithJoinFetch",Comment.class);
        Query query = entityManager.createQuery("select c from Comment c join fetch c.topic t" ,Comment.class);
        List<Comment> comments = query.getResultList();

        return comments;
    }

}
