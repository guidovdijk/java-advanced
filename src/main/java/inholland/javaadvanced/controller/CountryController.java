package inholland.javaadvanced.controller;

import inholland.javaadvanced.model.Beverage;
import inholland.javaadvanced.model.Country;
import inholland.javaadvanced.service.BeverageService;
import inholland.javaadvanced.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> getCountries() {
		return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable Integer id) {
		HttpStatus status = HttpStatus.OK;

		Country country =  countryService.getCountry(id);

		if (country == null) {
			status = HttpStatus.NOT_FOUND;
		}

		return ResponseEntity.status(status).body(country);
	}

}
