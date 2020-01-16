package recursion;
import java.util.Scanner;
public class BinarySearch {
	
    static int[]temp;

	
	public static int[] mergeSort(int[]arrays, int start, int end) {
		if(start<end) {
		int mid=(start+end)/2;
		mergeSort(arrays,start,mid);
		mergeSort(arrays,mid+1,end);
		merge(arrays, start, mid, end);
		}
		return arrays;
	}
	public static void merge(int[]arrays,int start, int mid, int end) {
		int i=start;
		int j=mid+1;
		int k=start;
		 
		if(i<=mid&&j<=end) {
			if(arrays[i]<=arrays[j]) {
				temp[k++]=arrays[i++];
			}
			else {
				temp[k++]=arrays[j++];
			}
		}
		
		while(i<=mid) {
			temp[k++]=arrays[i++];
		}
		
		while(j<=end) {
			temp[k++]=arrays[j++];
		}
		
		for(i=start;i<=end;i++) {
			arrays[i]=temp[i];
		}
		
	}
	
	public static int binarySearch(int[]arrays, int value, int start, int end) {
		if(start>end) {
			return -1;
		}
		int mid=(start+end)/2;
		if(arrays[mid]==value) {
			return mid;
		}
		else if(arrays[mid]>value) {
			return binarySearch(arrays, value, start, mid-1);
		}
		else {
			return binarySearch(arrays, value, mid+1, end);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("길이 입력");
		int length=sc.nextInt();
		System.out.println("배열 입력");
		int[]arr=new int[length];
		for(int i=0;i<length;i++) {
			arr[i]=sc.nextInt();
		}
		
	
		temp=new int[arr.length];
		
		
		
		int[]arrays=mergeSort(arr,0, arr.length-1);
		
		for(int i=0;i<arrays.length;i++) {
			System.out.print(arrays[i]+" ");
		}
		
		System.out.println("찾을 값 입력");
		int value=sc.nextInt();
		
		int position=binarySearch(arr, value, 0, arr.length-1);
		
		if(position!=-1) {
		    System.out.println(position);
		}
		else {
			System.out.println("not existied");	
		}
		
		sc.close();
	}

}
