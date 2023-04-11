package mk.finki.ukim.mk.lab.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.Country;
import mk.finki.ukim.mk.lab.model.enumeration.BookCategory;
import mk.finki.ukim.mk.lab.repository.AuthorRepository;
import mk.finki.ukim.mk.lab.repository.BookRepository;
import mk.finki.ukim.mk.lab.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializier {

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializier(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 5; i++) {
            countryRepository.save(new Country("Country " + i, "Contient: " + i));
            List<Country> countries = countryRepository.findAll();

            authorRepository.save(new Author("AuthorName: " + i, "Author surname: " + i, countries.get(i - 1)));
            List<Author> authors = authorRepository.findAll();

            bookRepository.save(new Book("BookName: " + i, BookCategory.DRAMA, authors.get(i - 1), 5));
        }
    }
}
