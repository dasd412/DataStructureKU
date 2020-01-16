package hashtable;

import java.util.ArrayList;
import java.util.List;

import heap.Entry;

public class HashTable<K,V> {

	private List<ArrayList<Entry<K,V>>>bucketArray;
	private int bucketCapacity;
	private int total;
	private double loadFactor;
	
	public HashTable(int initialCapacity) {
		bucketCapacity=initialCapacity;
		bucketArray=new ArrayList<>(bucketCapacity);
		total=0;
		loadFactor=0.9;
		
		for(int i=0;i<initialCapacity;i++) {
			bucketArray.add(null);
		}
		
	}

	
	private int hashFunc(String s) {
		int h=0;
		int a=33;
		
		for(int i=0;i<s.length();i++) {
			h=(h<<5)|(h>>>27);
			h+=(int)(s.charAt(i)*Math.pow(a, s.length()-i-1));
		}
		return Math.abs(h%bucketArray.size());
	}
	
	private void rehash(int capacity) {
		 List<ArrayList<Entry<K,V>>>temp=new ArrayList<>(capacity*2);
		 for(int i=0;i<capacity*2;i++) {
			 temp.add(null);
		 }
		 
		 for(int i=0;i<capacity;i++) {
			 temp.set(i, bucketArray.get(i));
		 }
		 
		 bucketArray=temp;
		 bucketCapacity=capacity*2;
		
	}
	
	
	public int size() {
		return bucketArray.size();
	}
	
	public String get(String k) {
		int index=hashFunc(k);
        ArrayList<Entry<K,V>>temp=bucketArray.get(index);
        if(temp==null) {
        	return null;
        }
        else {
        	String value=null;
        	for(int i=0;i<temp.size();i++) {
        		if(k.equals(temp.get(i).getKey())) {
        			value=(String) temp.get(i).getValue();
        		}
        	}
        	return value;
        }
	}
	
	public String put(String k, String v) {
		if(total/bucketCapacity*(1.0)>loadFactor) {
			rehash(bucketCapacity);
		}
		
		
		int index=hashFunc(k);
		Entry<K,V>entry=new Entry(k,v);
		if(bucketArray.get(index)==null) {
			
			ArrayList<Entry<K,V>>bucket=new ArrayList<>();
			bucketArray.set(index, bucket);
		}
		
		bucketArray.get(index).add(entry);
		this.total++;
		

		return (String) bucketArray.get(index).get(0).getValue();
	}
	
	public String remove(String k) {
		int index=hashFunc(k);
		
		if(bucketArray.get(index)==null) {
			return null;
		}
		
		ArrayList<Entry<K,V>>temp=bucketArray.get(index);
		
		String value=null;
		int i;
		for(i=0;i<temp.size();i++) {
			if(k.equals((String)temp.get(i).getKey())) {
				value=(String)temp.get(i).getValue();
				temp.remove(i);
				break;
			}
		}
		
		this.total--;
		return value;
	}
	
	public void print() {
		for(int i=0;i<bucketCapacity;i++) {
			if(bucketArray.get(i)==null) {
				System.out.println("[0]");
			}else {
				int len=bucketArray.get(i).size();
				for(int j=0;j<len;j++) {
					System.out.println(i+" "+(String)bucketArray.get(i).get(j).getValue());
				}
			}
		}
	}
}
