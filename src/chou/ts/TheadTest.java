package chou.ts;

public class TheadTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread1("n1");
		Thread t2 = new Thread1("n2");
		t1.start();
		t2.start();
		for(int i=0; i<999; i++) {
			if(i>500 && i%100==0)
				t1.join();
			System.out.println(Thread.currentThread().getName() + "--->" + i);
		}
	}

}

class Thread1 extends Thread{

	public Thread1(String name) {
		// TODO Auto-generated constructor stub
		this.setName(name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<999; i++) {
			System.out.println(this.getName() + "--->" + i);
		}
	}
	
}