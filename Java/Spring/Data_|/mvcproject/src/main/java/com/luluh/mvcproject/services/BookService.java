package com.luluh.mvcproject.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.luluh.mvcproject.models.Book;
import com.luluh.mvcproject.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    //update a book
//
//	public Book updateBook(Long id, String title, String desc, String lang, Integer numberOfPages) {
//		Optional<Book> optionalBook = bookRepository.findById(id);
//		  if(optionalBook.isPresent()) {
//			  Book optionalBook1 = optionalBook.get();
//			  optionalBook1.setTitle(title);
//			  optionalBook1.setDescription(desc);
//			  optionalBook1.setLanguage(lang);
//			  optionalBook1.setnumberOfPages(numberOfPages);
//			  return bookRepository.save(optionalBook1);   
//	        } else {
//	            return null;
//	        }
//		
//	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public @Valid Book updateBook(@Valid Book book) {
		Optional<Book> optionalBook = bookRepository.findById(book.getId());
		System.out.print("id is "+optionalBook);
		  if(optionalBook.isPresent()) {
			  Book optionalBook1 = optionalBook.get();
			  optionalBook1.setTitle(book.getTitle());
			  optionalBook1.setDescription(book.getDescription());
			  optionalBook1.setLanguage(book.getLanguage());
			  optionalBook1.setnumberOfPages(book.getnumberOfPages());
			  return bookRepository.save(optionalBook1);   
	        } else {
	            return null;
	        }
	}

	

}
