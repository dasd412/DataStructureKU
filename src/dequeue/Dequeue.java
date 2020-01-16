package dequeue;

import linkedlist.DoublelyLinkedList;

import linkedlist.Node;

public class Dequeue<E> {


	private DoublelyLinkedList<E>dequeue;
	
	public Dequeue() {

		this.dequeue=new DoublelyLinkedList<E>();
	}
	
	public int getSize() {
		return dequeue.getSize();
	}
	
	public boolean isEmpty() {
		return dequeue.isEmpty();
	}
	
	public E first() {
		return dequeue.first();
	}
	
	public E last() {
		return dequeue.last();
	}
	
	public void addFirst(E e) {
		dequeue.addFirst(e);
	}
	
	public void addLast(E e) {
		dequeue.addLast(e);
	}
	
	public void removeFirst() {
		dequeue.removeFirst();
	}
	
	public void removeLast() {
		dequeue.removeLast();
	}
	
	public void viewAll() {
		if(dequeue.isEmpty()) {
			System.out.println("It is Empty");
			return;
		}
		Node<E>it=dequeue.getHeader().getNext();
		while(it!=dequeue.getTrailer()) {
			System.out.println(it.getElement());
			it=it.getNext();
		}
	}
	
}
