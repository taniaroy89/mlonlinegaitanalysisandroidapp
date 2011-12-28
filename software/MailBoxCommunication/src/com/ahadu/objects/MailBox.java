/**
 * 
 */
package com.ahadu.objects;

import java.util.HashMap;
import java.util.Stack;

/**
 * A MailBox allows two or more threads to 
 * communicate by putting and getting any object
 * in it. 
 * The operations are blocking and allow the insertion
 * of one object at a time.
 * 
 * @author Ahadu
 */
public class MailBox<T> {
	protected volatile T buffer = null;
	public Stack<ObjectWrapper> stack = new Stack<ObjectWrapper>();
	private ObjectWrapper wrappedBuffer = new ObjectWrapper();
	
	/**
	 * A thread that calls this method on a MailBox object
	 * inserts an object in the one place buffer and  
	 * blocks all other accesses to it, until the place
	 * has been freed by an invocation of get().
	 * 
	 * TODO the console print makes the class not general, 
	 * should be implemented by subclass. 
	 * 
	 * @param object
	 */
	synchronized public void put(T object){
		if (buffer == null){
			buffer = object;
			System.out.println ("put: (" + ((Point)buffer).getX()+"," +((Point)buffer).getY()+")");
			wrappedBuffer.setObj(buffer);
			wrappedBuffer.setDescription("put");
			stack.push(wrappedBuffer);
			this.notifyAll();
		}else{
			try{
				this.wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * A thread invoking the get() on a MailBox object 
	 * pulls out the data in the buffer and deletes it
	 * from the buffer. If the buffer is empty, this 
	 * operation is blocking.
	 * 
	 * @TODO  the console print of the objects taken from 
	 * the mailbox should break the generality of the class
	 * should be done using a subclass like PointMailBClass
	 * 
	 * @return buffer, single object contained in the mailbox.
	 */
	synchronized public T get(){
		T temp = null;
		if(buffer == null){
			try {
				this.wait();
				temp = buffer;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			temp = buffer;
			System.out.println ("get: (" + ((Point)buffer).getX()+"," +((Point)buffer).getY()+")");
			wrappedBuffer.setObj(buffer);
			wrappedBuffer.setDescription("get");
			stack.push(wrappedBuffer);
			buffer = null;			
			this.notifyAll();
		}
		return temp;
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
