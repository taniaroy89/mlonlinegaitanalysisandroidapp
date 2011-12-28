/**
 * 
 */
package com.ahadu.objects;

/**
 * A MailBox allows two or more threads to 
 * communicate by putting and getting any object
 * in it. 
 * The operations are blocking and allow the insertion
 * of one object at a time.
 * 
 * @author Ahadu
 */
public class PointMailBox<T> extends MailBox<T>{
	//volatile private T buffer = null;

	synchronized public void put(T object){
		super.put(object);
		System.out.println ("put: (" + ((Point)buffer).getX()+"," +((Point)buffer).getY()+")");
	}
	
	synchronized public T get(){
		System.out.println ("get: (" + ((Point)buffer).getX()+"," +((Point)buffer).getY()+")");
		return super.get();
	}
	
	
//	synchronized public void putCond(T object){
//		if(buffer == null){
//			buffer = object;
//			System.out.println ("putCond: (" + buffer +")");
//		}
//	}
//	
//	synchronized public T getCond(){
//		T temp = null;
//		if(buffer != null){
//			
//		}else{
//			temp = buffer;
//			buffer = null;
//			System.out.println ("get: [ " + buffer +" ]");
//		}
//		return temp;
//	}
//	
//	synchronized public void putTimed(T object, long waitingTime){
//		if(buffer == null){
//			buffer = object;
//			System.out.println ("putTimed: (" + buffer +")");
//			this.notifyAll();
//		}else{
//			try{
//				this.wait(waitingTime);
//			}catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//		
//	synchronized public T getTimed(long waitingTime){
//		T temp = null;
//		if(buffer == null){
//			try {
//				this.wait(waitingTime);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}else{
//			temp = buffer;
//			buffer = null;
//	
//			System.out.println ("get: [ " + buffer +" ]");	
//			this.notifyAll();
//		}
//		return temp;
//	}

	
}
