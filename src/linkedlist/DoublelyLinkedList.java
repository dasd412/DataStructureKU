package linkedlist;

public class DoublelyLinkedList<E> implements LinkedList<E>{

	//멤버 변수
	private Node<E> header;
	private Node<E> trailer;
	private int size=0;
	
	//생성자
	
	public DoublelyLinkedList() {
		this.header=new Node<>(null,null,null);
		this.trailer=new Node<>(null,header, null);
		this.header.setNext(trailer);
	}
	
	//오버라이딩한 메소드
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size==0;
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		if(this.header==null) {
			return null;
		}
		else {
			return this.header.getElement();
		}
	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
		if(this.trailer==null) {
			return null;
		}
		else {
			return this.trailer.getElement();
		}
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		addBetween(e,header,header.getNext());
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		
		addBetween(e, trailer.getPrev(),trailer);
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		if(isEmpty())return null;
		
		
		return remove(header.getNext());
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		if(isEmpty())return null;
	
	    
		return remove(trailer.getPrev());
	}
	
	//추가한 메소드들
	
	public E remove(Node<E> node) {
		E element=node.getElement();
		
	    Node<E>predecessor=node.getPrev();
	    Node<E>successor=node.getNext();
	    
	    predecessor.setNext(successor);
	    successor.setPrev(predecessor);
	    
	    node.setNext(null);
	    node.setPrev(null);
		
		return element;
	}
	
	public void addBetween(E element, Node<E>predecessor, Node<E>successor) {
		Node<E>newest=new Node<E>(element);
		newest.setNext(successor);
		newest.setPrev(predecessor);
		
		predecessor.setNext(newest);
		successor.setPrev(newest);
		
		++this.size;
	}
	
	public void viewAll() {
		if(this.header==null)return;
		Node<E>it=this.header.getNext();
		while(it!=trailer) {
			
			System.out.println("Element::"+it.getElement());
			
			it=it.getNext();
		}
		
		
	}

	public Node<E> getHeader() {
		return header;
	}

	public Node<E> getTrailer() {
		return trailer;
	}
	
	

}
