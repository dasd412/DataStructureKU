package dfs;

import java.util.ArrayList;

import graph.Data;

public class StackDFS {

	private ArrayList<Data> stack;
	private int top;
	
	public StackDFS() {
		this.stack=new ArrayList<>();
		this.top=-1;
	}
	
	public int size() {
		return this.stack.size();
	}
	public void push(Data e) {
		this.top=top+1;
		stack.add(top,e);
	}
	
	public Data pop(){
		if(top<0) {
			return null;
		}
		Data temp=stack.get(top);
		stack.remove(top);
		this.top=top-1;
		return temp;
	}
}
