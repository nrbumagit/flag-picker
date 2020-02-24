package com.narendra.repositoryImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.narendra.dto.Root;
import com.narendra.repository.AllContinentDetails;
import com.narendra.serviceImpl.FlagPickerServiceImpl;

@Repository
public class AllContinentDetailsImpl implements AllContinentDetails{
	
	/*
	 * This method is used to load all continent details
	 */
	public List<Root> getAllContinentDetails() throws Exception, RuntimeException{
		List<Root> rootList = new ArrayList<Root>();
		ObjectMapper objectMapper = new ObjectMapper();
	    //read json file and convert to customer object
		ClassLoader classLoader = new FlagPickerServiceImpl().getClass().getClassLoader();
	    File file = new File(classLoader.getResource("config/continents.json").getFile());
	    rootList = objectMapper.readValue(file, new TypeReference<List<Root>>(){});
	    return rootList;
	}

	@Override
	public List<Integer> integersInput() {
		List<Integer> integers = new ArrayList<Integer>();
		integers.add(1);
		integers.add(8);
		integers.add(3);
		return integers;
	}

}
