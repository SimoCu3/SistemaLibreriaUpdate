package controller;

import model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AuthorService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @PostMapping()
    public ResponseEntity<Author> createNewAuthor(@RequestBody Author author){

        Author newAuthor = authorService.createNewAuthor(author);

        return ResponseEntity.ok(newAuthor);
    }


    @GetMapping()
    public ResponseEntity<List<Author>> getAllAuthor() throws Exception {

        List<Author> listAuthor = authorService.getAllAuthor();

        return ResponseEntity.ok(listAuthor);
    }

}

