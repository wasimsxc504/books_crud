package com.javatpoint.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.javatpoint.model.Books;
import com.javatpoint.service.BooksService;


@RestController
public class BooksController {
	
	@Autowired
	BooksService booksService;

//Retrieves all the books detail from the database 
	@GetMapping("/book")
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

//Retrieves the detail of a specific book
	@GetMapping("/book/{bookid}")
	private Books getBooks(@PathVariable("bookid") int bookid) {
		return booksService.getBooksById(bookid);
	}

//Deletes a specified book
	@DeleteMapping("/book/{bookid}")
	private void deleteBook(@PathVariable("bookid") int bookid) {
		booksService.delete(bookid);
	}

//Save book detail in the database
	@PostMapping("/books")
	private int saveBook(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books.getBookid();
	}

//Updates the book detail 
	@PutMapping("/books")
	private Books update(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books;
	}
}
