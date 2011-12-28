package com.ahadu.threadcommunications.ontwoobjects;

import com.ahadu.objects.MailBox;
import com.ahadu.objects.Point;

public class OnTwoObjectsCommTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MailBox<Point> mbx = new MailBox<Point>();
		Producer p = new Producer(mbx);
		Consumer c = new Consumer(mbx);
		
		p.start();
		c.start();
	}

}
