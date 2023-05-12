class A extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i+" ");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
		}
	}
}

class B extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println((char)(i+65)+" ");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
		}
	}
}
public class C {
	public static void main(String[] args) {
		new A().start();
		new B().start();
	}
}