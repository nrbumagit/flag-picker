package com.narendra.serviceImpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.narendra.dto.Country;
import com.narendra.dto.Root;
import com.narendra.repository.AllContinentDetails;

/*
 * This is the unit test class to test the service class methods. these unit tests run with JUnit4 test runner
 * @Mock is used to create the Mock
 * when() is used to stub the mock to return specific data
 * @InjectMocks - Inject the mocks as dependencies into ServiceImpl.
 * @RunWith(MockitoJUnitRunner.class) - The JUnit Runner which causes all the initialization magic with @Mock and @InjectMocks to happen before the tests are run
 * This unit test does not launch the complete Spring context.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlagPickerServiceImplTest {
	
	@Mock
	AllContinentDetails dataService;
	
	@InjectMocks
	FlagPickerServiceImpl service;
	

	@Test
	public void testGetContinentDetails() throws Exception,RuntimeException {
		List<Root> roots = new ArrayList<Root>();
		List<Country> countries = new ArrayList<Country>();
		
		Root root = new Root();
		root.setContinent("Africa");
		
		Country country1 = new Country();
		country1.setName("Nigeria");;
		country1.setFlag("🇳🇬");
		countries.add(country1);
		
		Country country2 = new Country();
		country2.setName("Ethiopia");;
		country2.setFlag("🇪🇹");
		countries.add(country2);
		
		Country country3 = new Country();
		country3.setName("Egypt");;
		country3.setFlag("🇪🇬");
		countries.add(country3);
		
		Country country4 = new Country();
		country4.setName("DR Congo");;
		country4.setFlag("🇨🇩");
		countries.add(country4);
		
		Country country5 = new Country();
		country5.setName("South Africa");;
		country5.setFlag("🇿🇦");
		countries.add(country5);
		
		root.setCountries(countries);
		
		roots.add(root);
		when(dataService.getAllContinentDetails()).thenReturn(roots);
		assertNotNull(service.getContinentDetails());
	}
	
	@Test
	public void testGetCountries() throws Exception,RuntimeException {
		List<Root> roots = new ArrayList<Root>();
		List<Country> countries = new ArrayList<Country>();
		
		Root root = new Root();
		root.setContinent("Africa");
		
		Country country1 = new Country();
		country1.setName("Nigeria");;
		country1.setFlag("🇳🇬");
		countries.add(country1);
		
		Country country2 = new Country();
		country2.setName("Ethiopia");;
		country2.setFlag("🇪🇹");
		countries.add(country2);
		
		Country country3 = new Country();
		country3.setName("Egypt");;
		country3.setFlag("🇪🇬");
		countries.add(country3);
		
		Country country4 = new Country();
		country4.setName("DR Congo");;
		country4.setFlag("🇨🇩");
		countries.add(country4);
		
		Country country5 = new Country();
		country5.setName("South Africa");;
		country5.setFlag("🇿🇦");
		countries.add(country5);
		
		root.setCountries(countries);
		
		roots.add(root);
		when(dataService.getAllContinentDetails()).thenReturn(roots);
		String expectedCountry = service.getCountries("Africa").stream().filter(item -> item.startsWith("DR Congo")).collect(Collectors.toList()).get(0);
		assertEquals("DR Congo",expectedCountry );
	}

	@Test
	public void testGetFlag() throws Exception,RuntimeException {
		List<Root> roots = new ArrayList<Root>();
		List<Country> countries = new ArrayList<Country>();
		
		Root root = new Root();
		root.setContinent("Africa");
		
		Country country1 = new Country();
		country1.setName("Nigeria");;
		country1.setFlag("🇳🇬");
		countries.add(country1);
		
		Country country2 = new Country();
		country2.setName("Ethiopia");;
		country2.setFlag("🇪🇹");
		countries.add(country2);
		
		Country country3 = new Country();
		country3.setName("Egypt");;
		country3.setFlag("🇪🇬");
		countries.add(country3);
		
		Country country4 = new Country();
		country4.setName("DR Congo");;
		country4.setFlag("🇨🇩");
		countries.add(country4);
		
		Country country5 = new Country();
		country5.setName("South Africa");;
		country5.setFlag("🇿🇦");
		countries.add(country5);
		
		root.setCountries(countries);
		
		roots.add(root);
		when(dataService.getAllContinentDetails()).thenReturn(roots);
		String expectedCountryFlag = service.getFlag("Africa", "DR Congo");
		System.out.println("expectedCountryFlag "+expectedCountryFlag);
		assertEquals("🇨🇩",expectedCountryFlag );
	}

	
}
