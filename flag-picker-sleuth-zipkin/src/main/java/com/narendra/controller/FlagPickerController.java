package com.narendra.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.constants.ControllerConstants;
import com.narendra.dto.Root;
import com.narendra.service.FlagPickerService;

/*
 * This is the rest controller class and this class has api methods to retrieve all continent details, country details and flag details
 */
@RestController
@RequestMapping("/picker")
public class FlagPickerController {

	public Logger logger = LoggerFactory.getLogger(FlagPickerController.class);
	
	@Autowired
	private FlagPickerService service;
	
	/*
	 * This is the rest controller api method to retrieve all continent details
	 */
	@GetMapping(path="/allContinents",produces = "application/json")
//	@HystrixCommand(fallbackMethod = "unknown")
	public List<Root> getContinentDetails() throws Exception, RuntimeException{
		logger.info(ControllerConstants.GET_CONTINENT_DETAILS+ControllerConstants.METHOD_START);
		List<Root> roots = service.getContinentDetails();
		logger.info(ControllerConstants.GET_CONTINENT_DETAILS+ControllerConstants.METHOD_END);
		return roots;
	}
	
	/*
	 * This is the rest controller api method to retrieve all country details for the given continent
	 */	
	@GetMapping(path="/countries/{continent}",produces = "application/json")
//	@HystrixCommand(fallbackMethod = "unknownCountries")
	public List<String> getContries(@PathVariable(required = false) String continent) throws Exception, RuntimeException{
		logger.info(ControllerConstants.GET_COUNTRIES+ControllerConstants.METHOD_START);
		List<String> countries = service.getCountries(continent);
		logger.info(ControllerConstants.GET_COUNTRIES+ControllerConstants.METHOD_END);
		return countries;
	}
	
	/*
	 * This is the rest controller api method to retrieve flag of the country
	 */	
	@GetMapping(path="/flag/{continent}/{country}",produces = "application/json")
//	@HystrixCommand(fallbackMethod = "unknownFlag")
	public String getFlag(@PathVariable(required = false) String continent, @PathVariable(required = false) String country ) throws Exception, RuntimeException{
		logger.info(ControllerConstants.GET_FLAG+ControllerConstants.METHOD_START);
		String flag = service.getFlag(continent,country);
		logger.info(ControllerConstants.GET_FLAG+ControllerConstants.METHOD_END);
		return flag;
	}
	
	public String unknown() {
		return "unknown";
	}
	
	public String unknownCountries() {
		return "unknown";
	}
	
	public String unknownFlag(String continent,String country,Throwable t) {
		return "unknown";
	}
	
	
}
