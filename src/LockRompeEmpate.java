import java.util.concurrent.atomic.AtomicIntegerArray;

public class LockRompeEmpate extends Lock{

	VolatileInt[] in;
	VolatileInt[] last;
	int n;
	
	protected void takeLock(int id) {
		for(int i = 1; i <= n;i++) {
			in[id].setN(i);
			last[i].setN(id);
			for(int k = 1;k <=n;k++) {
				if(k != id) {
					while(in[k].getN() >= in[id].getN() && last[i].getN() == id);
				}
			}
			
		}
	}
	
	protected void releaseLock(int id) {
		in[id].setN(0);
	}
	
	LockRompeEmpate(int n) {
		this.n = n;
		in = new VolatileInt[n+1];
		for(int i = 1; i<n+1;i++) {
			in[i] = new VolatileInt(0);
		}
		last = new VolatileInt[n+1];
		for(int i = 1; i<n+1;i++) {
			last[i] = new VolatileInt(0);
		}
	}
}
