package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller //tells Spring we want to make Spring MVC controller
public class BookController {
	
	private BookRepository bookRepository;
	
	
	//because we have a constructor at instatiation Spring is going to inject bookRepo-ry to the controller
	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}



	@RequestMapping("/books")///books is a path
	public String getBooks(Model model) {
		model.addAttribute( "books", bookRepository.findAll());
		return "books/list";//return the name of the "view"
	}

}
