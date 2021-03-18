public class Main {
	
	
	public static void main(String args[]) {
		//System.out.println("Ejercicio 1");
		//p2e1();
		System.out.println("Ejercicio 2");
		p2e2();

	}
	
	private static void p2e1() {
		Ejer1 ejer1 = new Ejer1();
		ejer1.start();
	}
	
	private static void p2e2() {
		Int2 n= new Int2(0);
		int ni = 7;
		Lock _lock = new LockTicket(ni*2);
		tThread2_2Dec[] dec = new tThread2_2Dec[ni];
		tThread2_2Inc[] inc = new tThread2_2Inc[ni];
		for(int i = 1; i <= (ni*2);i+=2) {
			dec[i/2] = new tThread2_2Dec(n, _lock, i);
			inc[i/2] = new tThread2_2Inc(n, _lock, i + 1);
			dec[i/2].start();
			inc[i/2].start();
		}
		for(int i = 0; i < ni;i++) {
			try {
				dec[i].join();
				inc[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}