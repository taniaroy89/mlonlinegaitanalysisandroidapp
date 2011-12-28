package com.ahadu.santanna.objects;

public class ObjectWrapper {
	private Object obj;
	private String description;
	
	public ObjectWrapper() {
		obj = null;
		description = "";
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
