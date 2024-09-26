package services;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;


    Map<Integer, Book> bookMap = new HashMap<>();
    AtomicInteger bookId = new AtomicInteger();


    //Post
    public Book createNewBook(Book book){
        book.setId(bookId.incrementAndGet());
        bookMap.put(book.getId(), book);
        return book;
    }


    //Get
    public Book getBookById(int bookId) throws Exception{
        return bookRepository.findById(bookId).orElseThrow(()-> new Exception("Book not found"));
    }

    public List<Book> getAllBooks() throws Exception {
        if (bookMap.isEmpty()) {
            throw new Exception("Book not found");
        }
        List<Book> bookList = new ArrayList<>(bookMap.values());
        return bookList;
    }

    //Pach
    public Book updateBookTitle(int id, String title) throws Exception{
        if(bookMap.containsKey(id)){
            Book book = bookMap.get(id);
            book.setTitle(title);
            return book;
        }
        throw new Exception("Book not fund");
    }


    //Delete
    public Boolean deleteBookById(int id){
        bookMap.remove(id);
        return true;
    }

}
