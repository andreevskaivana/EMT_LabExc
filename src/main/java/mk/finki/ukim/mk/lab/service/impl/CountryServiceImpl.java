package mk.finki.ukim.mk.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.finki.ukim.mk.lab.model.Country;
import mk.finki.ukim.mk.lab.model.dto.CountryDto;
import mk.finki.ukim.mk.lab.repository.CountryRepository;
import mk.finki.ukim.mk.lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAllCountries() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country=new Country(name,continent);
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        Country country=new Country(countryDto.getName(), countryDto.getContinent());
        this.countryRepository.save(country);
        return Optional.of(country);
    }


    @Override
    @Transactional
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country=this.countryRepository.findById(id).get();
        country.setName(name);
        country.setContinent(continent);
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, CountryDto countryDto) {
        Country country=this.countryRepository.findById(id).get();
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Country create(String name, String continent) {
        Country country=new Country(name,continent);
        return this.countryRepository.save(country);
    }

    @Override
    public Country update(Long id, String name, String continent) {
        Country c=this.countryRepository.findById(id).get();
        c.setName(name);
        c.setContinent(continent);
        return this.countryRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
