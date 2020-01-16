package stack;

public class ArrayStack<E> implements Stack<E>{

	private E[]data;
	private int top;
	
	public ArrayStack(int capacity){
		this.data=(E[]) new Object[capacity];
		this.top=-1;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.top+1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.top+1==0;
	}

	@Override
	public void Push(E e) throws IllegalStateException{
		// TODO Auto-generated method stub
		if(getSize()==data.length) {
			throw new IllegalStateException("Stack is full");
		}
		else {
		data[++top]=e;	
		}
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		else {
			return data[top];
		}
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			return null;
		}
		else {
			E temp=data[top];
			data[top]=null;
			--top;
			return temp;
		}
	}
	
	
}
