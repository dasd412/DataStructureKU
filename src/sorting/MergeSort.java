package sorting;

public class MergeSort {

	
	public void mergeSort(int[]arrays, int start, int end) {
		if(start>=end) {
			return;
		}
		else {
			int mid=(start+end)/2;
			mergeSort(arrays,start,mid);
			mergeSort(arrays,mid+1,end);
			merge(arrays,start,mid,end);
		}
	}
	
	private void merge(int[]arrays, int start, int mid, int end) {
		int[]temp=new int[arrays.length];
		int i=start;
		int j=mid+1;
		int k=start;
		
		while(i<=mid&&j<=end) {
			if(arrays[i]<arrays[j]) {
				temp[k]=arrays[i];
				k++;
				i++;
			}else {
				temp[k]=arrays[j];
				k++;
				j++;
			}
		}
		
		while(i<=mid) {
			temp[k]=arrays[i];
			k++;
			i++;
		}
		
		while(j<=end) {
			temp[k]=arrays[j];
			k++;
			j++;
		}
		
		for(int a=start; a<=end;a++) {
			arrays[a]=temp[a];
		}
		
	}
}
