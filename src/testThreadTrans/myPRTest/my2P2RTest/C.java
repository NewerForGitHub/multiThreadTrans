package testThreadTrans.myPRTest.my2P2RTest;

public class C{

	private Object lock;
	
	public C(Object lock) {
		this.lock = lock;
	}
	
	public void getValue() {
		synchronized (lock) {
			while("".equals(ValueObject.value)) {
				try {
					System.out.println("消费者" + Thread.currentThread().getName() + " WAITING 了☆");
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("消费者" + Thread.currentThread().getName() + " Runnable了");
			ValueObject.value = "";
			lock.notifyAll();
			
		}
	}

}
