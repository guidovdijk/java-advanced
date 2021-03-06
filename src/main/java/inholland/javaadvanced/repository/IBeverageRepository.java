package inholland.javaadvanced.repository;

import inholland.javaadvanced.model.Beverage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBeverageRepository extends CrudRepository<Beverage, Integer> {

}
