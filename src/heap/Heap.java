package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap<K,V> {

	private List<Entry<K,V>> heap;
	
	public Heap() {
		heap=new ArrayList<Entry<K,V>>();
		heap.add(null);
	}
	
	public int size() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		return heap.size()==0;
	}
	
	private boolean checkKey(K key)throws IllegalArgumentException {
		if(key instanceof Integer) {
			return true;
		}else {
			throw new IllegalArgumentException("Integer key needed.");
		}
		
	}
	
	private int leftChild(int n) {
		return 2*n;
	}
	
	private int rightChild(int n) {
		return 2*n+1;
	}
	private int parent(int n) {
		return n/2;
	}
	
	private void upheap(int lastNode, int lastKey) {
		int parent=parent(lastNode);
		if(lastNode<=1||lastKey>=(int)heap.get(parent).getKey()) {
			return;
		}
		else {
			Entry<K,V>temp=heap.get(lastNode);
			heap.set(lastNode, heap.get(parent));
			heap.set(parent, temp);
			upheap(parent,lastKey);
		}
	}
	
	private void downHeap(int rootKey, int position, int childNode) {
		
		if(rootKey<(int)heap.get(childNode).getKey()) {
			return;
		}else if((leftChild(childNode)>=heap.size()-1)||(rightChild(childNode)>=heap.size()-1)) {
			Entry<K,V>temp=heap.get(childNode);
			heap.set(childNode, heap.get(position));
			heap.set(position, temp);
			return;
		}
		else {
			Entry<K,V>temp=heap.get(childNode);
			heap.set(childNode, heap.get(position));
			heap.set(position, temp);
			
			int left=leftChild(childNode);
			int right=rightChild(childNode);
			
			
			if(left>right) {
				
				downHeap(rootKey,childNode, right);
			}else {
				downHeap(rootKey,childNode,left);
			}
		}
	}
	
	public void insert(Entry<K,V> entry) {
		checkKey(entry.getKey());
		heap.add(entry);
		
		int lastNode=heap.size()-1;
		int parent=parent(lastNode);
		
		
		int lastKey=(int) heap.get(lastNode).getKey();
		
		if(lastNode!=1) {
		int parentKey=(int)heap.get(parent).getKey();
		
		if(parentKey>lastKey) {
			upheap(lastNode, lastKey);
		}
		}
	}
	
	public Object removeMin() {
		Object minValue=heap.get(1).getValue();
		heap.set(1, heap.get(heap.size()-1));
		
		int rootKey=(int) heap.get(1).getKey();
		int leftNode=leftChild(1);
		int rightNode=rightChild(1);
		
		if(rootKey>(int)heap.get(leftNode).getKey()||rootKey>(int)heap.get(rightNode).getKey()) {
			int childNode;
			if((int)heap.get(leftNode).getKey()>(int)heap.get(rightNode).getKey()) {
				childNode=rightNode;
			}else {
				childNode=leftNode;
			}
			
			downHeap(rootKey,1,childNode);
		}
		
		heap.remove(heap.size()-1);
		
		return minValue;
	}

	public Object min() {
		Object minValue=heap.get(1).getValue();


		return minValue;
	}

	public void print() {
		for(int i=1;i<heap.size();i++) {
			System.out.println(heap.get(i).getKey()+" "+heap.get(i).getValue());
		}
	}
	
	
}
