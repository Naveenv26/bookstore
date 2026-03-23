package com.example.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookstore.model.*;
import com.example.bookstore.dao.*;
import java.util.*;

@Service
public class bookservice {

	@Autowired
	bookrepo br;
	
	
	
	public book get1(book b) {
		return br.save(b);
		
	}
	
	public List<book> get2(){
		return br.findAll();
	}
	
	public Optional<book> get3(int id){
		return br.findById(id);
	}
	
	public void get4(int id) {
		br.deleteById(id);
	}
}
