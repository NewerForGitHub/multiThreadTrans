package testThreadTrans.myWaitAndNotify.ab;

import testThreadTrans.mySleepAndWhile.MyList;

public class ThreadA extends Thread {

	private MyList list;
	
	public ThreadA(MyList list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		try {
			synchronized (list) {
				for(int i=0; i<10; i++) {
					list.add();
					System.out.println("添加了" + (i+1) + "个元素");
					if(list.size() == 5) {
						list.notify();
						System.out.println("发出通知");
					}
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
