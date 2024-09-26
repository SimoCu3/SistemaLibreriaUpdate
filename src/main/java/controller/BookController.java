package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import model.Book;
import services.BookService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping()
    public ResponseEntity<Book> createNewBook (@RequestBody Book book){
        Book newBook = bookService.createNewBook(book);
        return ResponseEntity.ok(newBook);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id")int id) throws Exception{
        Book foundBook = bookService.getBookById(id);
        return ResponseEntity.ok(foundBook);
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBook() throws Exception{

        List<Book> bookList = bookService.getAllBooks();
        return ResponseEntity.ok(bookList);
    }


    @PatchMapping("/book-name/{id}")
    public ResponseEntity<?> updateBookTitle(@PathVariable("id")int id, @PathVariable("name") String title) throws Exception{

        Book updatedBook = bookService.updateBookTitle(id, title);
        return ResponseEntity.ok(updatedBook);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBookById(@PathVariable("id")int id){
        Boolean deletedBook = bookService.deleteBookById(id);
        return ResponseEntity.ok(true);
    }

}
