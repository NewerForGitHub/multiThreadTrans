package testThreadTrans.myWaitAndNotify.myEarlierNotify;

public class MyRun {

	private Object lock = new Object();
	private boolean waitFlag = false;
	
	public Runnable runA = new Runnable() {
		@Override
		public void run() {
			synchronized (lock) {
				if(!waitFlag) {
					System.out.println(Thread.currentThread() + "==线程A准备wait");
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread() + "==线程Await结束");
				}
			}
		}
	};
	
	public Runnable runB = new Runnable() {
		@Override
		public void run() {
			synchronized (lock) {
				System.out.println(Thread.currentThread() + "==线程B准备notify");
				lock.notify();
				waitFlag = true;
				System.out.println(Thread.currentThread() + "==线程Bnotify结束");
			}
		}
	};
	
	
}
