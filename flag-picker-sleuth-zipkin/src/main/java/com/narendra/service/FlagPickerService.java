package com.narendra.service;

import java.util.List;

import com.narendra.dto.Root;

public interface FlagPickerService {
	
	public List<Root> getContinentDetails()  throws Exception,RuntimeException;
	public List<String> getCountries(final String continet) throws Exception,RuntimeException ;
	public String getFlag(final String continet,final String country)  throws Exception,RuntimeException;

}
