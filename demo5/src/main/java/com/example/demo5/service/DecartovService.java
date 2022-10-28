package com.example.demo5.service;

import com.example.demo5.dao.IPostDao;
import com.example.demo5.dao.ITopicDao;
import com.example.demo5.model.Image;
import com.example.demo5.model.Post;
import lombok.RequiredArgsConstructor;


import org.hibernate.annotations.QueryHints;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DecartovService {


    private final IPostDao iPostDao;

    @PersistenceContext
    EntityManager entityManager;

    public void add() {

        for (int i = 0; i < 5; i++) {
            Post post = new Post("topic" + i);
            Image image1 = new Image("url1_" + i);
            Image image2 = new Image("url2_" + i);
            post.addImage(image1);
            post.addImage(image2);
            Set<String> tags = Arrays.asList("red", "green", "blue", "orange", "white").stream().collect(Collectors.toSet());
            post.setTags(tags);
            iPostDao.save(post);
        }

    }

    public void getPost() {

        Query query = entityManager.createQuery("select distinct p " + "from Post p " + "left join fetch p.images " +
                "where p.id between :minId and :maxId ", Post.class);

        List<Post> posts = query.setParameter("minId", 1L)
                .setParameter("maxId", 1L)
                .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
                .getResultList();

        Query query1 = entityManager.createQuery("select distinct p " + "from Post p " + "left join fetch p.tags t " + "where p in :posts ", Post.class);

        posts = query1.setParameter("posts", posts).setHint(QueryHints.PASS_DISTINCT_THROUGH, false).getResultList();

        System.out.println(posts.size());
        for (int p = 0; p < posts.size(); p++) {
            System.out.println(posts.get(p).getTags());
        }
    }


    public  void find (){

            //List<Post> posts = entityManager.createQuery("select p from Post p ",Post.class).getResultList();
       // System.out.println(posts.size());
        List<Post> all = iPostDao.findAll();
        System.out.println(all.size());
        // System.out.println(posts.get(0));
       // Optional<Post> byId = iPostDao.findById(1L);
        //System.out.println(byId.get().getTitle());
    }

}
