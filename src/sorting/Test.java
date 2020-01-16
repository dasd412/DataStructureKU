package sorting;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		MergeSort merge=new MergeSort();
//		int[]arrays=new int[10];
//		for(int i=0;i<10;i++) {
//			int randNum=(int)((Math.random()*100)+1);
//			arrays[i]=randNum;
//		}
//		System.out.println("before");
//		for(int i=0;i<10;i++) {
//			System.out.println(arrays[i]);
//		}
//		
//		merge.mergeSort(arrays, 0, 9);
//		
//		System.out.println("after");
//		for(int i=0;i<10;i++) {
//			System.out.println(arrays[i]);
//		}
		
//		QuickSort quick=new QuickSort();
//		int[]arrays=new int[10];
//		for(int i=0;i<10;i++) {
//			int randNum=(int)((Math.random()*100)+1);
//			arrays[i]=randNum;
//		}
//		System.out.println("before");
//		for(int i=0;i<10;i++) {
//			System.out.println(arrays[i]);
//		}
//		
//		quick.quickSort(arrays, 0, 9);
//		
//		System.out.println("after");
//		for(int i=0;i<10;i++) {
//			System.out.println(arrays[i]);
//		}
	
		
		RadixSort radix=new RadixSort();
		
		int[]arrays=new int[10];
		for(int i=0;i<10;i++) {
			int randNum=(int)((Math.random()*1000)+1);
			arrays[i]=randNum;
		}
		System.out.println("before");
		for(int i=0;i<10;i++) {
			System.out.println(arrays[i]);
		}
		
		radix.radixSort(arrays);
		
		System.out.println("after");
		for(int i=0;i<10;i++) {
			System.out.println(arrays[i]);
		}
		
	}

}
