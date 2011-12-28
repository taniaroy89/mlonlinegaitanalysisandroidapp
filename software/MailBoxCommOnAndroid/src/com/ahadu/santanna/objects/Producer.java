package com.ahadu.santanna.objects;


public class Producer extends Thread {

	private MailBox<Point> produMbx;
	private int x;
	
	
	public Producer(MailBox<Point> mbx) {
		super();
		x = 0;
		produMbx = mbx;
		//start();
	}


	@Override
	public void run() {
		super.run();
		while(true){
			produMbx.put(new Point(x++, Math.sin(x)));
		}
	}
	
}
