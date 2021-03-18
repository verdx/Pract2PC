
public class tThread2_2Inc extends Thread{

	Int2 n;
	int id;
	Lock _lock;
	
	tThread2_2Inc(Int2 n, Lock lock, int id) {
		this.n = n;
		this._lock = lock;
		this.id = id;
		System.out.println("Hilo incrementador " + id + " creado.");
	}
	
	public void run() {
		for(int i = 0; i < 3;i++) {
			_lock.takeLock(id);
			n.n++;
			System.out.println("Hilo: "+ id + ": " + n.n);
			_lock.releaseLock(id);
		}
	}
}
