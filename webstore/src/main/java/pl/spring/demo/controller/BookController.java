package pl.spring.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.constants.ViewNames;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

/**
 * Book controller
 * 
 * @author mmotowid, Pawel Muntowski
 *
 */
@Controller
@RequestMapping("/books")
public class BookController {

	BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	/**
	 * Method collects info about all books
	 * @return info about all books
	 */ 
			 
	@RequestMapping
	public ModelAndView allBooks() {//wyświetl wszystie ksiązki
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject(ModelConstants.BOOK_LIST, bookService.findAllBooks());
		modelAndView.setViewName(ViewNames.BOOKS);
		return modelAndView;
	}

	/**
	 * Method shows info about book
	 * @param id
	 * @return info about book (name, author and status)
	 */
	@RequestMapping("/book")
	public ModelAndView bookInfo(@RequestParam("id") int id ){
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
	
	/**
	 * Method shows searching page
	 * @return modelAndView
	 */
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public ModelAndView showSearchPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(ViewNames.SEARCH);
		BookTo book = new BookTo();
		modelAndView.addObject(ModelConstants.SEARCH, book);
		return modelAndView;
	}
	
	/**
	 * Method search book in all library books, by name and/or author name and surname
	 * @param book
	 * @return modelAndView for book
	 */
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public ModelAndView searchBook(@ModelAttribute("findedBooks") BookTo book){
		ModelAndView modelAndView = new ModelAndView();
		List <BookTo> findedBooks = new ArrayList<>();
		String title = book.getTitle();
		String authors = book.getAuthors();
		if(!title.isEmpty() && !authors.isEmpty()){
			findedBooks = bookService.findBooksByTitle(title);
			findedBooks.addAll(bookService.findBooksByAuthor(authors));
		}else if(!title.isEmpty() && authors.isEmpty()){
			findedBooks = bookService.findBooksByTitle(title);
		}else if(title.isEmpty() && !authors.isEmpty()){
			findedBooks = bookService.findBooksByAuthor(authors);
		}else if(title.isEmpty() && authors.isEmpty()){			
		}		
		modelAndView.addObject("findedBooks", findedBooks);
		modelAndView.setViewName(ViewNames.FINDINGRESULT);				
		return modelAndView;
	}

	/**
	 * 
	 * @param id
	 * @return modelAndView for deleted book
	 */
	@RequestMapping(value="/delete/book", method = RequestMethod.GET)
	public ModelAndView deleteBook(@RequestParam("id") int id){
		ModelAndView modelAndView = new ModelAndView();	
		bookService.deleteBook(Long.valueOf(id));
		modelAndView.setViewName(ViewNames.BOOKDELETED);
		return modelAndView;
	}
	
	/**
	 * Binder initialization
	 */
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("id", "title", "authors", "status");
	}

}
