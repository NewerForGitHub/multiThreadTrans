package testThreadTrans.myWaitAndNotify.ab;

import testThreadTrans.mySleepAndWhile.MyList;

public class ThreadB extends Thread {

	private MyList list;
	
	public ThreadB(MyList list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		try {
			synchronized (list) {
				if(list.size() != 5) {
					System.out.println(Thread.currentThread().getName() + "==线程A开始等待");
					list.wait();
					System.out.println(Thread.currentThread().getName() + "==线程A等待结束");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
