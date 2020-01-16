package priortyQueue;

public interface PriortyQueue <K,V>{

	int getSize();
	boolean isEmpty();
	Entry<K,V> insert(K key, V value)throws IllegalArgumentException;
	Entry<K,V> min();
	Entry<K,V> removeMin();
}
