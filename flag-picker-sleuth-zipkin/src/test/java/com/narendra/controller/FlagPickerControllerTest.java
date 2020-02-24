package com.narendra.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.narendra.dto.Country;
import com.narendra.dto.Root;
import com.narendra.service.FlagPickerService;

/*
 * This is the unit test class to test the rest controller class methods. these unit tests run with JUnit4 test runner
 * @RunWith(SpringRunner.class) - Spring Runner is used to launch up a spring context in unit tests.
 * @MockBean annotation creates a mock for Service. This mock is used in the Spring Context instead of the real DataService
 * when() is used to stub the mock to return specific data
 * @SpringBootTest - This annotation indicates that the context under test is a @SpringBootApplication. The complete SpringBootTutorialBasicsApplication is launched up during the unit test.
 * @RunWith(MockitoJUnitRunner.class) - The JUnit Runner which causes all the initialization magic with @Mock and @InjectMocks to happen before the tests are run
 * This unit test does not launch the complete Spring context.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class FlagPickerControllerTest {

	@MockBean
	FlagPickerService dataService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	/*
	 * @Autowired FlagPickerService service;
	 */

	@Test
	public void testGetContinentDetails() throws Exception, RuntimeException {
		List<Root> roots = new ArrayList<Root>();

		Root root = new Root();
		root.setContinent("Africa");

		List<Country> countries = new ArrayList<Country>();
		Country country1 = new Country();
		country1.setName("Nigeria");
		country1.setFlag("🇳🇬");
		countries.add(country1);

		Country country2 = new Country();
		country2.setName("Ethiopia");
		country2.setFlag("🇪🇹");
		countries.add(country2);

		Country country3 = new Country();
		country3.setName("Egypt");
		country3.setFlag("🇪🇬");
		countries.add(country3);

		Country country4 = new Country();
		country4.setName("DR Congo");
		country4.setFlag("🇨🇩");
		countries.add(country4);

		Country country5 = new Country();
		country5.setName("South Africa");
		country5.setFlag("🇿🇦");
		countries.add(country5);

		root.setCountries(countries);

		roots.add(root);

		Root root1 = new Root();
		root1.setContinent("America");

		List<Country> cntrys = new ArrayList<Country>();
		Country cntry1 = new Country();
		cntry1.setName("USA");
		;
		cntry1.setFlag("🇺🇸");
		cntrys.add(cntry1);

		Country cntry2 = new Country();
		cntry2.setName("Brazil");
		;
		cntry2.setFlag("🇧🇷");
		cntrys.add(cntry2);

		Country cntry3 = new Country();
		cntry3.setName("Mexico");
		;
		cntry3.setFlag("🇲🇽");
		cntrys.add(cntry3);

		Country cntry4 = new Country();
		cntry4.setName("Colombia");
		;
		cntry4.setFlag("🇨🇴");
		cntrys.add(cntry4);

		Country cntry5 = new Country();
		cntry5.setName("Argentina");
		;
		cntry5.setFlag("🇦🇷");
		cntrys.add(cntry5);

		root1.setCountries(cntrys);

		roots.add(root1);

		when(dataService.getContinentDetails()).thenReturn(roots);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/picker/allContinents")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Json data " + result.getResponse().getContentAsString());
		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void testGetCountries() throws Exception, RuntimeException {
		List<String> africaCountries = new ArrayList<String>();
		africaCountries.add("USA");
		africaCountries.add("Brazil");
		africaCountries.add("Mexico");
		africaCountries.add("Colombia");
		africaCountries.add("Argentina");

		when(dataService.getCountries("Africa")).thenReturn(africaCountries);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/picker/countries/Africa")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Countries Json data " + result.getResponse().getContentAsString());
		assertNotNull(result.getResponse().getContentAsString());

	}

	@Test
	public void testGetFlag() throws Exception, RuntimeException {
		when(dataService.getFlag("Africa", "Egypt")).thenReturn("🇪🇬");

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/picker/flag/Africa/Egypt")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Flag Json data " + result.getResponse().getContentAsString());
		assertNotNull(result.getResponse().getContentAsString());
	}

}
