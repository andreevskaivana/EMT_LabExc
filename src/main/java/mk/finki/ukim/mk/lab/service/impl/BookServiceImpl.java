package mk.finki.ukim.mk.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.dto.BookDto;
import mk.finki.ukim.mk.lab.model.enumeration.BookCategory;
import mk.finki.ukim.mk.lab.repository.AuthorRepository;
import mk.finki.ukim.mk.lab.repository.BookRepository;
import mk.finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> listAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Book> save(String name, BookCategory bookCategory, Long authorId, int availableCopies) {
        Author author=this.authorRepository.findById(authorId).get();
        this.bookRepository.deleteByName(name);
        Book book=new Book(name,bookCategory,author,availableCopies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }


    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author=this.authorRepository.findById(bookDto.getAuthorId()).get();
        this.bookRepository.deleteByName(bookDto.getName());
        Book book=new Book(bookDto.getName(),bookDto.getBookCategory(),author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    @Transactional
    public Optional<Book> edit(Long id, String name, BookCategory bookCategory, Long authorId, int availableCopies) {
        Book book=this.bookRepository.findById(id).get();

        book.setName(name);
        book.setCategory(bookCategory);

        Author author=this.authorRepository.findById(authorId).get();
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book=this.bookRepository.findById(id).get();
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getBookCategory());
        Author author=this.authorRepository.findById(bookDto.getAuthorId()).get();
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Book create(String name, BookCategory category, Long authorId, int availableCopies) {
        Author a=authorRepository.findById(authorId).get();
        Book book=new Book(name,category,a,availableCopies);
        return this.bookRepository.save(book);
    }

    @Override
    public Book update(Long id, String name, BookCategory category, Long authorId, int availableCopies) {
        Author a=this.authorRepository.findById(authorId).get();
        Book book=this.bookRepository.findById(id).get();
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(a);
        book.setAvailableCopies(availableCopies);
        return this.bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book delete(Long id) {
        Book book=bookRepository.findById(id).get();
        this.bookRepository.delete(book);
        return book;
    }

    @Override
    public Optional<Book> availableCopies(Long id) {
        Book books=this.bookRepository.findById(id).get();
        int availableCopies=books.getAvailableCopies();
        books.setAvailableCopies(--availableCopies);
        if (availableCopies<=0)
            books.setAvailableCopies(0);
        this.bookRepository.save(books);
        return Optional.of(books);
    }


}
