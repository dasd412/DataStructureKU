package linkedlist;

public class Node<E> {

	
		private E element;
		private Node<E>prev;
		private Node<E>next;

		public Node(E element){
		this.element=element;
		}

		public Node(E element, Node<E>p, Node<E>n){
		this.element=element;
		this.prev=p;
		this.next=n;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		


}
