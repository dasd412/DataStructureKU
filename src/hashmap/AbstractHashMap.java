package hashmap;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V>{

	protected int n=0;
	protected int capacity;
	private int prime;//prime factor;
	private long scale, shift;//shift and scaling factors
	
	public AbstractHashMap(int cap, int p) {
		prime=p;
		capacity=cap;
		Random rand=new Random();
		scale=rand.nextInt(prime-1)+1;
		shift=rand.nextInt(prime);
		createTable();
	}
	
	public AbstractHashMap(int cap) {
		this(cap, 109345121);
	}//default prime
	
	public AbstractHashMap() {
		this(17);
	}//default capacity

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		V answer=bucketPut(hashValue(key),key,value);
		if(n>capacity/2) {
			resize(2*capacity-1);
		}
		return answer;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return bucketGet(hashValue(key),key);
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return bucketRemove(hashValue(key),key);
	}

	
	public abstract Iterable<Entry<K, V>> entrySet();
	
	private int hashValue(K key) {
		return (int)((Math.abs(key.hashCode()*scale+shift)%prime)%capacity);
	}
	
	private void resize(int newCap) {
		ArrayList <Entry<K,V>> buffer=new ArrayList<>(n);
		for(Entry<K,V>e:entrySet()) {
			buffer.add(e);
		}
		capacity=newCap;
		createTable();
		n=0;
		for(Entry<K,V>e:buffer) {
			put(e.getKey(),e.getValue());
		}
	}
	
	protected abstract void createTable();
	
	protected abstract V bucketGet(int h, K k);
	
	protected abstract V bucketPut(int h, K k, V v);
	
	protected abstract V bucketRemove(int h, K k);
	
}
