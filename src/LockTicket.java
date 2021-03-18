import java.util.concurrent.atomic.AtomicInteger;

public class LockTicket extends Lock {
	
	int next;
	AtomicInteger number;
	
	public LockTicket(int n) {
		number = new AtomicInteger(1);
		next = 1;
	}

	@Override
	protected void takeLock(int id) {
		int turn;
		turn = number.getAndAdd(1);
		while(turn != next);
	}

	@Override
	protected void releaseLock(int id) {
		next++;
	}

}
