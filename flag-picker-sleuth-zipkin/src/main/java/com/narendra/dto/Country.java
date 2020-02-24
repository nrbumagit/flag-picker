package com.narendra.dto;
public class Country
{
    private String name;

    private String flag;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setFlag(String flag){
        this.flag = flag;
    }
    public String getFlag(){
        return this.flag;
    }
	@Override
	public String toString() {
		return "Countries [name=" + name + ", flag=" + flag + "]";
	}
    
    
}