package com.narendra.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narendra.constants.ServiceConstants;
import com.narendra.dto.Country;
import com.narendra.dto.Root;
import com.narendra.repository.AllContinentDetails;
import com.narendra.service.FlagPickerService;

@Service
public class FlagPickerServiceImpl implements FlagPickerService {

	public Logger logger = LoggerFactory.getLogger(FlagPickerServiceImpl.class);

	@Autowired
	AllContinentDetails repo;

	@Override
	public List<String> getCountries(String continent) throws Exception, RuntimeException {
		logger.info(ServiceConstants.GET_COUNTRIES + ServiceConstants.METHOD_START + continent);
		List<String> countries = new ArrayList<String>();
		List<Root> rootList = repo.getAllContinentDetails();
		List<Root> continentBasedList = rootList.stream().filter(e -> e.getContinent().contains(continent))
				.collect(Collectors.toList());
		logger.debug(ServiceConstants.CONTINENT_BASED_FILTERED_LIST + continentBasedList);
		List<Country> listOfCountries = continentBasedList.get(0).getCountries();
		listOfCountries.forEach((country) -> {
			countries.add(country.getName());
		});
		logger.debug(ServiceConstants.LIST_OF_COUNTRIES_AND_FLAGS_UNDER_THE_CONTINENT + continent + ServiceConstants.ARE
				+ listOfCountries);
		logger.info(ServiceConstants.GET_COUNTRIES + ServiceConstants.METHOD_END);
		return countries;
	}

	@Override
	public String getFlag(String continent, String country) throws Exception, RuntimeException {
		logger.info(ServiceConstants.GET_FLAG + ServiceConstants.METHOD_START + continent + " " + country);
		String flag = "";
		List<Root> rootList = repo.getAllContinentDetails();
		List<Root> continentBasedList = rootList.stream().filter(e -> e.getContinent().contains(continent))
				.collect(Collectors.toList());
		logger.debug(ServiceConstants.CONTINENT_BASED_FILTERED_LIST + continentBasedList);
		List<Country> listOfCountries = continentBasedList.get(0).getCountries();
		logger.debug(ServiceConstants.LIST_OF_COUNTRIES_AND_FLAGS_UNDER_THE_CONTINENT + continent + ServiceConstants.ARE
				+ listOfCountries);
		Optional<Country> cntry = listOfCountries.stream().filter(item -> item.getName().equalsIgnoreCase(country))
				.findAny();
		flag = cntry.get().getFlag();
		logger.info(ServiceConstants.GET_FLAG + ServiceConstants.METHOD_END);
		return flag;
	}

	@Override
	public List<Root> getContinentDetails() throws Exception, RuntimeException {
		List<Root> rootList = repo.getAllContinentDetails();
		return rootList;
	}

}
