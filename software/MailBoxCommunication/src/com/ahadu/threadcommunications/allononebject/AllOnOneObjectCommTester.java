package com.ahadu.threadcommunications.allononebject;

import com.ahadu.objects.MailBox;
import com.ahadu.objects.Point;
import com.ahadu.objects.PointMailBox;

public class AllOnOneObjectCommTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//final MailBox<Point> mbx = new PointMailBox<Point>();
		final MailBox<Point> mbx = new MailBox<Point>();
		
		Thread producer = new Thread(){
			private double x;

			public void run(){
				while(true){
					mbx.put(new Point(x++, Math.sin(x)));
				}
			}
		};
		
		Thread consumer = new Thread(){
			public void run(){
				while(true){
					mbx.get();
				}
			}
		};
		
		
		producer.start();
		consumer.start();
		
	}

}
