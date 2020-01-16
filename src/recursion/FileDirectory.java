package recursion;
import java.io.File;

public class FileDirectory {

	public static long getDiskUsage(File root) {
		long total=root.length();
		if(root.isDirectory()) {
			for(String childName:root.list()) {
				File child=new File(root, childName);
			    total+=getDiskUsage(child);
			}
		}
		System.out.println(total+"\t"+root);
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File root=new File("D:/konkukjava");

		System.out.println("total:: "+getDiskUsage(root));
	}

}
