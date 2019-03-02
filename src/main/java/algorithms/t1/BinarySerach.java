package algorithms.t1;

public class BinarySerach {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5};
		int index = rank(4,a);
		System.out.println(index);
		
	}
	
	/*private static int rank(int key, int[] a) {
		int length = a.length-1;
		int temp = 0;
		while (temp <= length) {
			int index = (temp+length)/2;
			if (key == a[index]) return index;
			
			if (key < a[index]) {
				length = index;
				continue;
			}
			
			if (key > a[index]) {
				temp = index;
				continue;
			}
		}
		
		return -1;
	}*/
	
	private static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi -lo) / 2;
			if (key < a[mid]) 
				hi = mid - 1;
			else if (key > a[mid]) 
				lo = mid + 1;
			else 
				return mid;
		}
		return -1;
	}

}
