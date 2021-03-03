package cn.me.DateTest;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread mythread = new MyThread();
        new Thread(mythread).start();
        new Thread(mythread).start();
        new Thread(mythread).start();
        new Thread(mythread).start();
        new Thread(mythread).start();
        new Thread(mythread).start();
    }
}

class MyThread implements Runnable {
    int tickets = 100;
    
    @Override
    public void run() {
        while(tickets > 0) {
            synchronized(this) {
                if(tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "买票:" + tickets);
                    tickets--;
                }
            }
        }
    }
}
