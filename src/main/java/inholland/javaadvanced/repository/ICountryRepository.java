package inholland.javaadvanced.repository;

import inholland.javaadvanced.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends CrudRepository<Country, Integer> {
}
