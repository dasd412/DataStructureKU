package queue;

import stack.ArrayStack;

public class DoubleStackQueue<E> implements Queue<E> {

	private ArrayStack<E> inStack;
	private ArrayStack<E> outStack;
	
	
	public DoubleStackQueue(int capacity) {
		this.inStack=new ArrayStack<E>(capacity); 
		this.outStack=new ArrayStack<E>(capacity); 
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return inStack.getSize()+outStack.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return inStack.getSize()+outStack.getSize()==0;
	}

	@Override
	public E front() throws EmptyQueueException {
		// TODO Auto-generated method stub
		while(!(this.inStack.isEmpty())) {
			this.outStack.Push(inStack.top());
		}
	    return this.outStack.top();
	}

	@Override
	public void enqueue(E e) throws FullQueueException {
		// TODO Auto-generated method stub
		while(!this.outStack.isEmpty()) {
			this.inStack.Push(this.outStack.pop());
		}
		this.inStack.Push(e);
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		while(!(this.inStack.isEmpty())) {
			this.outStack.Push(inStack.top());
		}
	    return this.outStack.pop();
	}

	
	
}
