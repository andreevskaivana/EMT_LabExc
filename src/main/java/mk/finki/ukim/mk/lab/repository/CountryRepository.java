package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    List<Country> findCountriesByContinent(String continent);

}
