/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

class A {

	public synchronized void foo(B b) {

		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " entered A.foo");

		try {
			Thread.sleep(1000);
		} catch (Exception ex) {
			System.out.println("A Interrrupted");
		}
		System.out.println(threadName + " trying to call B.last()");
		b.last();

	}

	public synchronized void last() {
		System.out.println("Inside A.last");
	}
}

class B {

	public synchronized void foo(A a) {

		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " entered B.foo");

		try {
			Thread.sleep(1000);
		} catch (Exception ex) {
			System.out.println("B Interrrupted");
		}

		System.out.println(threadName + " trying to call A.last()");
		a.last();

	}

	public synchronized void last() {
		System.out.println("Inside B.last");
	}
}

/**
 * 
 * @author PenGuin
 */
public class DeadLock implements Runnable {

	private A a = new A();
	private B b = new B();

	public DeadLock() {

		Thread.currentThread().setName("MainThread");
		Thread t = new Thread(this, "DeadLockThread");
		t.start();

		b.foo(a);
		System.out.println("Back in the main thread");
	}

	public void run() {
		a.foo(b);
		System.out.println("Back in the other thread");
	}

	public static void main(String[] args) {
		// new DeadLock();

		final A a = new A();
		final B b = new B();

		new Thread(new Runnable() {

			public void run() {
				a.foo(b);
			}
		}).start();

		b.foo(a);

		// new other.thread(new Runnable() {
		//
		// public void run() {
		// b.foo(a);
		// }
		// }).start();

	}
}
