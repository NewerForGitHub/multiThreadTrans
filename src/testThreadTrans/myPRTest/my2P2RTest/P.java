package testThreadTrans.myPRTest.my2P2RTest;

public class P{

	private Object lock;
	
	public P(Object lock) {
		this.lock = lock;
	}
	
	public void setValue() {
		synchronized (lock) {
			while(!"".equals(ValueObject.value)) {
				try {
					System.out.println("生产者" + Thread.currentThread().getName() + " WAITING 了★");
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			String value = System.currentTimeMillis() + "_" + System.nanoTime();
			System.out.println("生产者" + Thread.currentThread().getName() + " Runnable了");
			ValueObject.value = value;
			lock.notifyAll();
			
		}
	}

}
