package com.ahadu.threadcommunications.ontwoobjects;

import com.ahadu.objects.MailBox;
import com.ahadu.objects.Point;

public class Consumer extends Thread {

	private MailBox<Point> consumerMbx;
	
	public Consumer(MailBox<Point> consumerMbx) {
		super();
		this.consumerMbx = consumerMbx;
		//start();
	}

	@Override
	public void run() {
		super.run();
		while(true){
			consumerMbx.get();
		}
	}

}
