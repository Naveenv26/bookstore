package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstore.model.*;
import com.example.bookstore.service.*;
import java.util.*;


@RestController
public class bookcontroller {
	
	@Autowired
	bookservice bs;

	@PostMapping("/abc")
	public ResponseEntity <book> set1(@RequestBody book b){
		book b1=bs.get1(b);
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}
	
	@GetMapping("/home")
	public List<book> set2(){
		return bs.get2();
	}
	
	@GetMapping("/sel/{id}")
	public ResponseEntity <book> set3(@PathVariable int id ){
		Optional<book> b=bs.get3(id);
		return b.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<book> set4(@PathVariable int id ,@RequestBody book b){
		
		if(!bs.get3(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		b.setId(id);
		book b1=bs.get1(b);
		return ResponseEntity.ok(b1);
		
	}
	
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<book> set5(@PathVariable int id ){
			
			if(!bs.get3(id).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			bs.get4(id);
			return ResponseEntity.noContent().build();
	
}
}
