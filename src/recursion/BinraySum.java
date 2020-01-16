package recursion;

public class BinraySum {
    public static int binarySum(int[]arrays,int start, int end) {
    	if(end==1) {
    		return arrays[start];
    	}
    	else {//Math.ceil는 올림을 뜻함. 리턴값의 유형은 double이므로 형변환 필요.
    		return binarySum(arrays,start,(int)(Math.ceil((double)end/2)))+binarySum(arrays,start+(int)(Math.ceil((double)end/2)),end/2);
    	
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[]arrays=new int[100];
     
     for(int i=0;i<99;i++) {
    	 arrays[i]=i+1;
    	 
     }

     int result=binarySum(arrays, 0,99);
     System.out.println(result);
     
	}

}
