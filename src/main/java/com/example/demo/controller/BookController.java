package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//@RestController serve per indicare una classe che gestisce le richieste HTTP e restituisce dati in formato JSON.
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081/")
public class BookController
{
    @Autowired
    private BookRepository bookRepository;


    //gestisce la richiesta GET per ottenere tutti i libri.
    @GetMapping("/book")
    public List<Book> fetchBook(){
        return bookRepository.findAll();
    }

    /*
    *gestisce la richiesta POST per aggiungere un nuovo libro.
    *@RequestBody serve per prelevare i dati dal frontend e li deserializza dentro book
    */
    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    /*
    * gestisce la richiesta PUT per effettuare una cancellazione "soft" di un libro per eliminarlo dal frontend ma non dal db
    * quindi sostanzialmente fa un update
     */
    @PutMapping("/book/{id}/soft-delete")
    public void softDeleteBook(@PathVariable Long id)
    {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent())
        {
            Book book = optionalBook.get();
            //imposta data di cancellazione nel momento in cui viene eliminato il libro
            book.setDelDate(LocalDate.now());
            //salva libro aggiornato del db
            bookRepository.save(book);


        }
    }

    // Gestisce la richiesta PUT per aggiornare le informazioni di un libro
    @PutMapping("/book/{id}")
    public void  updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();

            //aggiorna i campi del libro con i nuovi valori
            book.setName(updatedBook.getName());
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setIsbn_code(updatedBook.getIsbn_code());
            book.setAddDate(updatedBook.getAddDate());
            book.setDelDate(updatedBook.getDelDate());
            book.setPlot(updatedBook.getPlot());
            book.setReadCounter(updatedBook.getReadCounter());

            //salva il libro aggiornato
            bookRepository.save(book);
        }
    }
}