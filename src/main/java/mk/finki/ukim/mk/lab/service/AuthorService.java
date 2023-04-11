package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Country;
import mk.finki.ukim.mk.lab.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAllAuthors();
    Optional<Author> findById(Long id);
    List<Author> findAllByCountry(Country country);

    Optional<Author> edit(Long id, String name, String surname, Long countryId);

    Optional<Author> edit(Long id, AuthorDto authorDto);
    void deleteById(Long id);
}
