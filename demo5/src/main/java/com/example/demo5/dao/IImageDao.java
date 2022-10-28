package com.example.demo5.dao;

import com.example.demo5.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageDao extends JpaRepository<Image,Long> {
}
