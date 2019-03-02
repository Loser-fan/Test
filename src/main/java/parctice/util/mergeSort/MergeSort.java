package parctice.util.mergeSort;

import org.apache.log4j.Logger;

public class MergeSort {
	
	private static Logger log = Logger.getLogger(MergeSort.class);
	
	/**
	 * 自顶向上归并
	 * 使用递归排序，对array[left,right]进行排序
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void mergeSortUpDown(int[] array, int left, int right) {
		
		if (left >= right)
			return;
		
		//如果一个数组的个数小于一定值的时候，插入排序的效率会比归并排序高。比如15
		/*
		 if ((right - left) < 15) {
			//插入排序。。。。。
		}
		*/
		
		int mid = (left + right) / 2;
		
		mergeSortUpDown(array, left, mid);
		mergeSortUpDown(array, mid+1, right);
		//如果左数组最大值小于右数组最小值，不用merge
		if (array[mid] > array[mid+1])  
			__merge(array, left, mid, right);
	}
	
	
	public static void mergeSortDownUp(int[] array, int left, int right) {
		
		int length = array.length;
		/*
		for (int gap = 1; 2*gap <= length; gap *= 2) {
			left = 0;
			while ((left + 2*gap - 1) < length) {
				__merge(array, left, left + gap - 1, left + 2*gap - 1);
				left += 2*gap;
			}
			
			if (left < length) {
				__merge(array,left - 2*gap, left - 1, right);
			}
		}
		*/
		
		for (int gap = 1; gap <= length; gap += gap) {
			
			for (int i = 0; i + gap < length; i += 2*gap) {
				//最后的边界 判断是否有足够的个数
				if ((i + gap + gap - 1 ) < (length - 1)) {
					__merge(array, i, i + gap - 1, i + gap + gap - 1);	
				}else {
					__merge(array, i, i + gap - 1, length - 1);
				}
				
			}
		}
	}
	
	/**
	 * 将array[left,mid] 和 array[mid+1, right] 两部分数组进行归并
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 */
	private static void __merge(int[] array, int l, int m, int r) {
		
		//创建一个临时数组进行归并
		int[] temp = new int[r-l+1];
		for (int i = 0; i < r-l+1; i++) {
			temp[i] = array[l + i];
		}
		
		int i = l;
		int j = m + 1;
		for (int k = l;k <= r; k++) {
			if (i > m) {
				array[k] = temp[j - l];
				j++;
			}
			else if (j > r){
				array[k] = temp[i - l];
				i++;
			}
			else if (temp[i - l] < temp[j - l]) {
				array[k] = temp[i - l];
				i++;
			}
			else {
				array[k] = temp[j - l];
				j++;
			}
		}
	}

}
