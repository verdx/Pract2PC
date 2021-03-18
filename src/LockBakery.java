import java.util.concurrent.atomic.AtomicIntegerArray;

public class LockBakery extends Lock {

	VolatileInt[] turn;
	int n;
	
	public LockBakery(int n) {
		this.n = n;
		turn = new VolatileInt[n+1];
		for(int i = 1; i<n+1;i++) {
			turn[i] = new VolatileInt(0);
		}
	}
	
	@Override
	protected void takeLock(int id) {
		turn[id].setN(1);
		turn[id].setN(max(turn)+1);
		for(int i = 1; i < (n+1);i++) {
			if(i != id) while(turn[i].getN() != 0 && mayorque(turn[id].getN(), id, turn[i].getN(), i));
		}

	}

	@Override
	protected void releaseLock(int id) {
		turn[id].setN(0);
	}
	
	private int max(VolatileInt[] in) {
		int max = 0;
		for(int i = 1; i < in.length;i++) {
			if(in[i].getN() > max) max = in[i].getN();
		}
		return max;
	}
	
	private boolean mayorque(int a, int b, int c, int d) {
		if(a > c) return true;
		else if(a == c && b > d) return true;
		else return false;
	}
	
	

}
