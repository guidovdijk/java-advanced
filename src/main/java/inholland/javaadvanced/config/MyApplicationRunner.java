package inholland.javaadvanced.config;

import inholland.javaadvanced.model.Beverage;
import inholland.javaadvanced.model.Country;
import inholland.javaadvanced.repository.IBeverageRepository;
import inholland.javaadvanced.repository.ICountryRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Component
public class MyApplicationRunner implements ApplicationRunner {
	private IBeverageRepository IbeverageRepository;
	private ICountryRepository ICountryRepository;

	public MyApplicationRunner(IBeverageRepository ibeverageRepository, ICountryRepository iCountryRepository) {
		IbeverageRepository = ibeverageRepository;
		ICountryRepository = iCountryRepository;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		Country country1 = new Country(1, "The Netherlands");
		Country country2 = new Country(2, "Germany");
		Country country3 = new Country(3, "Belgium");

		List<Country> countries = new ArrayList<>(
			List.of(
				country1,
				country2,
				country3
			)
		);

		countries.forEach(this.ICountryRepository::save);

		Beverage bacardi = new Beverage(1, "Bacardi", 40.0, 42.50, country1);
		Beverage wodka = new Beverage(2, "Wodka", 45.5, 21.00, country1);
		Beverage morgan = new Beverage(3, "Captain Morgan", 34.0, 39.99, country2);

		List<Beverage> beverages = new ArrayList<>(
						List.of(
										bacardi,
										wodka,
										morgan
						)
		);

		beverages.forEach(this.IbeverageRepository::save);

		this.IbeverageRepository.findAll().forEach(System.out::println);
		this.ICountryRepository.findAll().forEach(System.out::println);
	}
}
