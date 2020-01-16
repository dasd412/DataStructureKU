package sorting;

import java.util.ArrayList;


public class RadixSort {

	private ArrayList<Integer>[]bucket;
	
	public RadixSort() {
		this.bucket=new ArrayList[10];
		for(int i=0;i<10;i++) {
			bucket[i]=new ArrayList<Integer>();
		}
	}
	
	public void radixSort(int[]arrays) {

		int max=arrays[0];
		
		
		for(int i=0;i<arrays.length;i++) {
			if(max<arrays[i]) {
				max=arrays[i];
			}
		}
		
		int count=1;
		
		while(max>0) {
			count++;
			max=max/10;
		}
		
		int mod=10;
		int div=1;
		
		for(int i=1;i<=count;i++, mod*=10, div*=10) {
			for(int j=0;j<arrays.length;j++) {
                int digit=(arrays[j]%mod)/div;
                 
//				if(bucket.get(digit)==null) {
//					ArrayList<Integer>integers=new ArrayList<>();
//					bucket.set(digit, integers);
//				}
				bucket[digit].add(arrays[j]);
			}

			int k=0;
			int index=0;
			while(k<arrays.length) {
				if(bucket[index]!=null) {
					for(int l=0;l<bucket[index].size();l++) {
						arrays[k++]=bucket[index].get(l);
				        
					}
					index++;
				}
			}
			
			this.bucket=new ArrayList[10];
			for(int m=0;m<10;m++) {
				bucket[m]=new ArrayList<Integer>();
			}
          
		}
		
	}
}
