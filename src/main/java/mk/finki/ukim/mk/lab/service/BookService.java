package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.dto.BookDto;
import mk.finki.ukim.mk.lab.model.enumeration.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAllBooks();

    Optional<Book> findById(Long id);

    Optional<Book> save(String name, BookCategory bookCategory, Long authorId, int availableCopies);

    Optional<Book> save(BookDto productDto);

    Optional<Book> edit(Long id, String name, BookCategory bookCategory,Long authorId, int availableCopies);

    Optional<Book> edit(Long id, BookDto bookDto);

    Book create(String name,BookCategory category,Long authorId,int availableCopies);

    Book update(Long id,String name,BookCategory category,Long authorId,int availableCopies);

    void deleteById(Long id);
    Book delete(Long id);
    Optional<Book> availableCopies(Long id);
}
