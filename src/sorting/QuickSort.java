package sorting;

public class QuickSort {

	
	public void quickSort(int[]arrays, int start, int end) {
		if(start>=end) {
			return;
		}
		else {
			int pivot=partition(arrays, start, end);
			quickSort(arrays,start,pivot-1);
			quickSort(arrays,pivot+1,end);
		}
	}
	
	private int partition(int[]arrays, int start, int end) {
		int i=start-1;
		
		int pivot=arrays[end];
		
		for(int j=start;j<end;j++) {
			if(arrays[j]<pivot) {
				i=i+1;
				int temp=arrays[i];
				arrays[i]=arrays[j];
				arrays[j]=temp;
			}
		}
		
		
		int temp=arrays[i+1];
		arrays[i+1]=arrays[end];
		arrays[end]=temp;
		
		return i+1;
		
		
	}
}
