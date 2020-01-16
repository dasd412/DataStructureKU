package stack;

public interface Stack<E> {

	public int getSize();
	public boolean isEmpty();
	public void Push(E e);
	public E top();
	public E pop();
}
