package com.example.bookstore.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.model.*;


public interface bookrepo extends JpaRepository<book,Integer> {

}
