package parctice.util.mergeSort;

import org.apache.log4j.Logger;

public class MergeSort {
	
	private static Logger log = Logger.getLogger(MergeSort.class);
	
	/**
	 * �Զ����Ϲ鲢
	 * ʹ�õݹ����򣬶�array[left,right]��������
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void mergeSortUpDown(int[] array, int left, int right) {
		
		if (left >= right)
			return;
		
		//���һ������ĸ���С��һ��ֵ��ʱ�򣬲��������Ч�ʻ�ȹ鲢����ߡ�����15
		/*
		 if ((right - left) < 15) {
			//�������򡣡�������
		}
		*/
		
		int mid = (left + right) / 2;
		
		mergeSortUpDown(array, left, mid);
		mergeSortUpDown(array, mid+1, right);
		//������������ֵС����������Сֵ������merge
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
				//���ı߽� �ж��Ƿ����㹻�ĸ���
				if ((i + gap + gap - 1 ) < (length - 1)) {
					__merge(array, i, i + gap - 1, i + gap + gap - 1);	
				}else {
					__merge(array, i, i + gap - 1, length - 1);
				}
				
			}
		}
	}
	
	/**
	 * ��array[left,mid] �� array[mid+1, right] ������������й鲢
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 */
	private static void __merge(int[] array, int l, int m, int r) {
		
		//����һ����ʱ������й鲢
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
