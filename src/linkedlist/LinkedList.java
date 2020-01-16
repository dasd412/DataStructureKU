package linkedlist;

public interface LinkedList<E> {

	public int getSize();
	public boolean isEmpty();
	public E first();
	public E last();
	public void addFirst(E e);
	public void addLast(E e);
	public E removeFirst();
	public E removeLast();
	
	
	
}
