package testThreadTrans.myWaitAndNotify;

public class MyThread2 extends Thread {

	private Object lock;
	
	public MyThread2(Object lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		synchronized (lock) {
			System.out.println("¿ªÊ¼ notifytime=" + System.currentTimeMillis());
			lock.notify();
			System.out.println("½áÊø notifytime=" + System.currentTimeMillis());
		}
	}

}
