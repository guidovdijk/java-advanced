package inholland.javaadvanced.service;

import inholland.javaadvanced.model.Beverage;
import inholland.javaadvanced.model.Country;
import inholland.javaadvanced.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CountryService {

	@Autowired
	private ICountryRepository countryRepo;

	public List<Country> getCountries(){
		return (List<Country>) countryRepo.findAll();
	}

	public Country getCountry(Integer id){
		return countryRepo.findById(id).orElseThrow(EntityNotFoundException::new);
	}
}
