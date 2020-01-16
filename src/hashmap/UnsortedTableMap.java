package hashmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K,V> extends AbstractMap<K,V> {
	//This map is very inefficient.

	private ArrayList<MapEntry<K,V>>table=new ArrayList<>();
	
	public UnsortedTableMap() {
		
	}
	
	private int findIndex(K key) {
		int n=table.size();
		for(int j=0;j<n;j++) {
			if(table.get(j).getKey().equals(key)) {
				return j;
			}
		}
		return -1;
	}
	
	public int size() {
		return table.size();
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		int index=findIndex(key);
		if(index==-1) {
			table.add(new MapEntry(key , value));
			return null;
		}
		else {
			return table.get(index).setValue(value);
		}
		
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		int index=findIndex(key);
		if(index==-1) {
			return null;
		}
		return table.get(index).getValue();
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		int index=findIndex(key);
		int n=size();
		
		if(index==-1) {
			return null;
		}
		V answer=table.get(index).getValue();
		if(index!=n-1) {
			table.set(index, table.get(n-1));
		}
		table.remove(n-1);
		return answer;
	}

	private class EntryIterator implements Iterator<Entry<K,V>>{
		private int j=0;
		
		public boolean hasNext() {
			return j<table.size();
		}
		
		public Entry<K,V> next(){
			if(j==table.size()) {
				throw new NoSuchElementException();
			}
			return table.get(j++);
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}//class
	
	private class EntryIterable implements Iterable<Entry<K,V>>{
		public Iterator<Entry<K,V>>iterator(){
			return new EntryIterator();
		}
	}//class
	
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return new EntryIterable();
	}
	
	
	
}
