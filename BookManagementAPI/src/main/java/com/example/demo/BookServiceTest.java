package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class BookServiceTest {
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookService bookService;
	

	@Test
	void testAddBook_Success() {
	    Book book = new Book("lime", "for", "crime");
	    
	    when(bookRepository.save(any(Book.class))).thenReturn(book);

	    Book result = bookService.createBook(book);

	    assertNotNull(result);
	    assertEquals("lime", result.getTitle());
	    assertEquals("for", result.getAuthor());
	    assertEquals("crime", result.getGenre());
	}
	 @Test
	    void testGetBookById_Success() {
	        Book book = new Book("lime", "for", "crime");
	        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

	        Book result = bookService.getBookById(1L);

	        assertNotNull(result);
	        assertEquals(1L, result.getId());
	        assertEquals("for", result.getAuthor());
	    }

	 @Test
	    void testGetBookById_NotFound() {
	        when(bookRepository.findById(5L)).thenReturn(Optional.empty());

	        Exception exception = assertThrows(RuntimeException.class, () -> {
	            bookService.getBookById(5L);
	        });

	        assertEquals("Book not found", exception.getMessage());
	    }

	

}
