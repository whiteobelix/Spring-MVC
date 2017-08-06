package pl.spring.demo.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.controller.BookController;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private BookService bookService;
	
	@Before
	public void setup(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates/");
		viewResolver.setSuffix(".html");
		mockMvc = MockMvcBuilders.standaloneSetup(new BookController(bookService)).setViewResolvers(viewResolver).build();
	}

	@Test
	public void ShouldReturnBooksViewAndListOfBooksInModel() throws Exception{	
		//given when
		List<BookTo> listOfBooks = new ArrayList <BookTo>();
		ResultActions resultActions = mockMvc.perform(get("/books"));
				
		//then
		resultActions.andExpect(view().name("books"))
		.andExpect(model().attribute(ModelConstants.BOOK_LIST, listOfBooks));	
	}
	
	@Test
	public void xxxShouldReturnBooksViewAndListOfBooksInModel() throws Exception{	
		//given when
		ResultActions resultActions = mockMvc.perform(get("/books/book?id=1"));
				
		//then
		resultActions.andExpect(view().name("book"));
		//.andExpect(model().attribute(ModelConstants.BOOK_LIST, listOfBooks));	
	}
	
}
