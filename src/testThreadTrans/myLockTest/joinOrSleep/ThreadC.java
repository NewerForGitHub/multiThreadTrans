package testThreadTrans.myLockTest.joinOrSleep;

public class ThreadC extends Thread {
    private ThreadA a;

    public ThreadC(ThreadA a) {
        this.a = a;
    }

    @Override
    public void run() {
        this.a.aService();
    }

}
