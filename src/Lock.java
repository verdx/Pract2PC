
public abstract class Lock {

	protected abstract void takeLock(int id);
	protected abstract void releaseLock(int id);
}
