package com.narendra.dto;

import java.util.ArrayList;
import java.util.List;

public class RootList {
	
	private List<Root> roots = new ArrayList<Root>();

	public List<Root> getRoots() {
		return roots;
	}

	public void setRoots(List<Root> roots) {
		this.roots = roots;
	}

	@Override
	public String toString() {
		return "RootList [roots=" + roots + "]";
	}
	
	
	

}
