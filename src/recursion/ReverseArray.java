package recursion;

public class ReverseArray {

	public static void reverseArr(int[]arrays, int start, int end) {
		if(start>end) {
			return;
		}
		else {
		int temp=arrays[start];
		arrays[start]=arrays[end];
		arrays[end]=temp;
		reverseArr(arrays, start+1,end-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]arrays= {5,4,13,152,2,1};
		reverseArr(arrays, 0, arrays.length-1);
		for(int arr:arrays) {
			System.out.print(arr+" ");
		}
	}

}
