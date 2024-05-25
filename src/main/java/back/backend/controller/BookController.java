package back.backend.controller;

import back.backend.exceptions.ResourceNotFoundException;
import back.backend.model.Book;
import back.backend.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public boolean createBook(@RequestBody Book book) {

        if(!this.repository.isItBanned(book.getBookTitle()))
        {
            book.setID();
            repository.save(book);
            return true;
        }
        else
        {
            throw new ResourceNotFoundException("Book banned");
        }
    }

    @PutMapping("/{title}")
    public void updateBook(@PathVariable String title, @RequestBody Book bookDetails) {
        Book book = repository.findByTitle(title); // Assuming you have a method like this in your repository

        if (book != null) {
            repository.updateBook(title,bookDetails.getBookTitle(),bookDetails.getAuthor(),bookDetails.getNoOfPages());
        } else {
            throw new ResourceNotFoundException("Book not found!");
        }
    }

    @DeleteMapping("/{title}")
    public void deleteBook(@PathVariable String title) {
        repository.deleteByTitle(title);
    }
}