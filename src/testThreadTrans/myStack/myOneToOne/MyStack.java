package testThreadTrans.myStack.myOneToOne;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

	private List<String> list = new ArrayList<String>();
	
	public synchronized void push() {
		try {
			if(list.size() == 1) {
				System.out.println("push操作：" + Thread.currentThread().getName() + " 线程呈wait状态");
				this.wait();
			}
			list.add("随机数=" + Math.random());
			this.notify();
			System.out.println("push=" + list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized String pop() {
		String value = "";
		try {
			if(list.size() == 0) {
				System.out.println("pop操作：" + Thread.currentThread().getName() + " 线程呈wait状态");
				this.wait();
			}
			value = list.get(0);
			list.remove(0);
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return value;
	}
	
}
