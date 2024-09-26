package services;

import model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import repository.AuthorRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;


    Map<Integer, Author> authorMap = new HashMap<>();
    AtomicInteger authorId = new AtomicInteger();


    //Post
    public Author createNewAuthor(Author author){

        author.setId(authorId.incrementAndGet());
        authorMap.put(author.getId(), author);

        return author;
    }


    //Get
    public List<Author> getAllAuthor() throws Exception{

        if(authorMap.isEmpty()){
            throw new Exception("Author not found");
        }
        List<Author> authorList = new ArrayList<>(authorMap.values());

        return authorList;
    }

}
