package back.backend.repository;

import back.backend.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> books;

    public BookRepository() {
        init();
    }

    public List<Book> bannedBooks;
    private void init() {
        books = new ArrayList<>(Arrays.asList(
                new Book("Fourth Wing", "Rebbeca Yarros", 321),
                new Book("Ion", "Liviu Rebreanu", 248),
                new Book("A Game of Thrones", "George R. R. Martin", 912),
                new Book("The Two Towers", "J. R. R. Tolkien", 452)
        ));

        bannedBooks = new ArrayList<>(Arrays.asList(
                new Book("The Bluest Eye","Toni Morrison",322),
                new Book("Gender Queer: A Memoir","Maia Kobabe",122),
                new Book("Of Mice and Men","John Steinbeck",451)
        ));

    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null; // Or throw an exception if not found
    }

    public void save(Book book) {

        books.add(book);
    }
    public void updateBook(String title, String newTitle, String newAuthor, int newNoOfPages) {
        for (Book book : books) {
            if (book.getBookTitle().equals(title)) {
                book.setBookTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setNoOfPages(newNoOfPages);
                return;
            }
        }
    }
    public void deleteByTitle(String title) {
        books.removeIf(book -> book.getBookTitle().equals(title));
    }

    public boolean isItBanned(String title)
    {
        for (Book book : bannedBooks) {
            if (book.getBookTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getBookTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getBanned()
    {
        return this.bannedBooks;
    }

}
