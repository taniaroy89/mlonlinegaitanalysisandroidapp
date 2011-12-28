package com.ahadu.santanna.objects;

import java.text.DecimalFormat;




public class Point {
	private double x; 
	private double y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		String newline = System.getProperty("line.separator");
		
		return "x: "+df.format(x) +  ", "  + "y: "+df.format(y);
	}
	
	// GETTERS AND SETTERS
	
	
	}
