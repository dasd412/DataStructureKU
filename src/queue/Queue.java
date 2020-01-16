package queue;

public interface Queue<E> {

	public int getSize();
	public boolean isEmpty();
	public E front()throws EmptyQueueException;
	public void enqueue(E e)throws FullQueueException;
	public E dequeue()throws EmptyQueueException;
}
