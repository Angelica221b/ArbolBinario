package Queue;

public interface iQueue<T> {
	public void enQueue(T value) throws QueueFullException;

	public T deQueue() throws QueueEmptyException;

	public boolean isEmpty();

	public boolean isFull();

	public T front() throws QueueEmptyException;

	public T search(T value) throws QueueEmptyException;
	
	public void clear();
	
	public int size();
}