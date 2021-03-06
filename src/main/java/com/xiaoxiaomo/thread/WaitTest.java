package com.xiaoxiaomo.thread;

public class WaitTest {

	
	private Integer num=new Integer(0);
	
	private String numnew="str";
	
	public static void main(String[] args) {
		
		new WaitTest().test();
		
	}

	private void test() {
		
		//使Test就绪状态
		new Thread(new Test()).start();
		new Thread(new Test()).start();
		new Thread(new Test()).start();
		new Thread(new Test()).start();

		new Thread(new Test()).start();
		new Thread(new Test()).start();
		new Thread(new Test()).start();
		new Thread(new Test()).start();
		new Thread(new Test()).start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		synchronized (num) {
			//num.notifyAll();//
			num.notify();//会通知最先进入等待锁的那一个
		}
		
		
	}
	
	
	

	class Test implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			try {
				
				
				
				synchronized (num) {
					System.out.println("begin wait："+Thread.currentThread().getName());
					//wait 时候释放当前的锁
					num.wait(100000);
					//sleep的时候会一只持有当前的锁
					//Thread.sleep(10000);
					
					System.out.println("end wait："+Thread.currentThread().getName());
				}
				
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	
	
}
