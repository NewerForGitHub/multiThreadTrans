package testThreadTrans.myWaitAndNotify.myListNotify;

public class Add extends Thread{

	private Object lock;
	
	public Add(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			System.out.println("向List中添加字符串");
			ValueObject.list.add("我滴个神啊");
			System.out.println("添加成功，notify全部线程");
			lock.notifyAll();
		}
	}
	
}
