package queue;

public class CircularQueue<E> implements Queue<E>{

	private E[]data;
	private int front;
	private int rear;
	
	public CircularQueue(int capacity) {
		this.data=(E[]) new Object[capacity];
		this.front=0;
		this.rear=0;
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return (data.length-(front-rear))%data.length;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front==rear;
	}

	@Override
	public E front() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new EmptyQueueException("Queue is Empty");
		}
		else {						
			return data[front];
		}
	}

	@Override
	public void enqueue(E e) throws FullQueueException {
		// TODO Auto-generated method stub
		if(getSize()==data.length-1) {
			throw new FullQueueException("Queue is Full");
		}
		else {
			data[rear]=e;
			rear=(rear+1)%data.length;
		}
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new EmptyQueueException("Queue is Empty");
		}
		else {
			E temp=data[front];
			front=(front+1)%data.length;
			return temp;
		}
	}

	
}
