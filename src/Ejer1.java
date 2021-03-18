
public class Ejer1 extends Thread{

	volatile boolean in1, in2;
	volatile int last;
	
	
	public void run() {
		Int2 n = new Int2(0);
		tThread2_1Dec thread1 = new tThread2_1Dec(n);
		tThread2_1Inc thread2 = new tThread2_1Inc(n);
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public class tThread2_1Dec extends Thread{
		Int2 n;
		
		tThread2_1Dec(Int2 n) {
			this.n = n;
		}
		
		public void run() {
			for(int i = 0; i < 30;i++) {
				in1 = true;
				last = 1;
				while(in2 && last ==1);
				n.n--;
				in1 = false;
				System.out.println("1: " + n.n);
			}
		}

	}
	
	public class tThread2_1Inc extends Thread{
		Int2 n;
		
		tThread2_1Inc(Int2 n) {
			this.n = n;
		}
		
		public void run() {
			for(int i = 0; i < 30;i++) {
				in2 = true;
				last = 2;
				while(in1 && last == 2);
				n.n++;
				in2 = false;
				System.out.println("2: " + n.n);
			}
		}
	}

}
