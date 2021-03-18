
public class VolatileInt{
	volatile int n;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public VolatileInt(int n) {
		this.n = n;
	}
	
}
