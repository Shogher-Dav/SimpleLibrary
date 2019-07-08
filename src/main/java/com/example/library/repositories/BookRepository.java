package com.example.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.library.entities.Book;

public interface BookRepository  extends CrudRepository<Book, Integer>{
	
	@Query(value = "SELECT title FROM book WHERE author=?", nativeQuery = true)
	public List<String> getByAuthor(String author);
	

}
