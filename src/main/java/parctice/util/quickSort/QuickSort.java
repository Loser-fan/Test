package parctice.util.quickSort;

public class QuickSort {
	
	public static int[] quickSort(int[] array, int left, int right) {
		
		int len = array.length;
		
		if (left >= right) {
			return array;
		} 
		
		int index = partSort(array, left, right);
		quickSort(array, left, index-1);
		quickSort(array, index+1, right);
		
		return array;
	}

	public static int partSort(int[] array, int left, int right) {
		
		int key = array[left];
		int index = left;
		
		while (left < right) {
			
			while (left < right && array[right] >= key) {
				right--;
			}
			while (left < right && array[left] <= key) {
				left++;
			}
			
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
		}
		
		array[index] = array[left];
		array[left] = key;
		
		return left;
		
	}
}
