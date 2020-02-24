package com.narendra.dto;

import java.util.List;

public class Root
{
    private String continent;

    private List<Country> countries;

    public void setContinent(String continent){
        this.continent = continent;
    }
    public String getContinent(){
        return this.continent;
    }
    public void setCountries(List<Country> countries){
        this.countries = countries;
    }
    public List<Country> getCountries(){
        return this.countries;
    }
	@Override
	public String toString() {
		return "Root [continent=" + continent + ", countries=" + countries + "]";
	}
    
    
}