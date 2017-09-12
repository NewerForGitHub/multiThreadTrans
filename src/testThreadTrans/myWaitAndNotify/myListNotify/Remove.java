package testThreadTrans.myWaitAndNotify.myListNotify;

public class Remove extends Thread{

	private Object lock;
	
	public Remove(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while(ValueObject.list.size() == 0) {
//			if(ValueObject.list.size() == 0) {
				System.out.println("list.size()=0," + Thread.currentThread().getName() + "线程进入等待状态");
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "线程等待结束");
			}
			System.out.println("移除list的第一个对象");
			ValueObject.list.remove(0);
			System.out.println("移除后，list.size()=" + ValueObject.list.size());
		}
	}
	
}
