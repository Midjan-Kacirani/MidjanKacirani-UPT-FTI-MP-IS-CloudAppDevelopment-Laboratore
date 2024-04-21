package com.hendisantika.springbootrestapipostgresql.controller;

import com.hendisantika.springbootrestapipostgresql.entity.Author;
import com.hendisantika.springbootrestapipostgresql.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RestController()
@RequestMapping("/authors")
public class AuthorRestController {
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping()
    public List<Author> getAllAuthors() {
        log.info("Kerkese per te marr te gjithe autoret erdhi ne server!");
        return authorRepository.findAll();
    }

    @PostMapping()
    public Author saveAuthor(@RequestBody(required = true) Author author) {

        log.info("Kerkese per te ruajtur nje autor te ri erdhi ne server!");
        return authorRepository.save(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        log.info("Kerkese per te perditesuar autorin me Id: " + id + "erdhi ne server!");
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            author.setId(id);
            return new ResponseEntity<>(authorRepository.save(author), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthorById(@PathVariable Long id) {
        log.info("Kerkese per te fshire autorin me Id: " + id + "erdhi ne server!");
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            authorRepository.deleteById(id);
            return new ResponseEntity<>(authorOptional.get(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
