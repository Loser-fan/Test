package parctice.util;

import java.util.ArrayList;
import java.util.Arrays;

import parctice.util.mergeSort.MergeSort;
import parctice.util.quickSort.QuickSort;
import sun.font.CreatedFontTracker;

public class SortUtil {
	/**
	 * ϣ������  Shell Sort  ������������ʹ�ò��������ƶ�����
	 * ���������ƶ����� ��鿴 Insertion Sort 2.0
	 * @param array
	 * @return
	 */
	public static int[] shellSort(int[] array) {

		int length = array.length;
		int tk;    //����
		for (tk = length / 2; tk > 0; tk /= 2) {
			
			for (int i = tk; i < length; i++) {
				
				//ʹ�ò��������ƶ�����
				int j = i;
				int temp = array[j];
				for (j = i; j - tk >= 0; j -= tk) {
					if (temp < array[j - tk]) {
						array[j] = array[j - tk];
					} else
						break;
				}
				array[j] = temp;
				
//				//ʹ�ò���������뷨
//				for (int j = i; j - tk >= 0; j -= tk) {
//					if (array[j] < array[j - tk]) {
//						int temp = array[j - tk];
//						array[j - tk] = array[j];
//						array[j] = temp;
//					}else 
//						break;
//				}
			}
		}
		
		return array;
	}

	/**
	 * ֱ������
	 * @param array
	 * @return
	 */
	public static int[] sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		print(array);
		return array;
	}
	
	/**
	 * ð������ Bubble Sort
	 * @param array
	 * @return
	 */
	public static int[] bubbleSort(int[] array) {
		
		int length = array.length;
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < length - i; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * ѡ������ Selection sort
	 * @param array
	 * @return
	 */
	public static int[] selectionSort(int[] array) {

		int length = array.length;
		for (int i = 0; i < length; i++) {
			int index = i; // ��С����λ��
			for (int j = i+1; j < length; j++) {
				if (array[index] > array[j])
					index = j;
			}
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		return array;
	}
	
	/**
	 * method verion 1.0
	 * �������� insertionSort
	 * @param array
	 * @return
	 */
	public static int[] insertionSort(int[] array) {
		
		int length = array.length;
		for (int i = 1; i < length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j-1]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				} else {
					break;
				}
			}
		}
		return array;
	}
	
	/**
	 * method verion 2.0  �Ż���
	 * �������� insertionSort
	 * @param array
	 * @return
	 */
	public static int[] insertionSort2(int[] array) {
		
		int length = array.length;
		for (int i = 1; i < length; i++) {
			
			int j = i;
			//Ѱ��temp�ʺϲ����λ��j
			int temp = array[j];
			for (j = i; j > 0 && temp < array[j-1]; j--) {
				array[j] = array[j-1];
			}
			array[j] = temp;   
		} 
		return array;
	}
	
	/**
	 * �鲢����  Merge Sort �Զ����·�ʽ
	 * @param array
	 * @return
	 */
	public static int[] mergeSortUpDown(int[] array) {
		
		int length = array.length;
		
		MergeSort.mergeSortUpDown(array, 0, length - 1);
		return array;
	}
	
	/**
	 * �鲢����  Merge Sort �Ե����Ϸ�ʽ
	 * @param array
	 * @return
	 */
	public static int[] mergeSortDownUp(int[] array) {
		
		int length = array.length;
		
		MergeSort.mergeSortDownUp(array, 0, length - 1);
		return array;
	}
	
	
	public static int[] quickSort(int[] array) {
		
		QuickSort.quickSort(array, 0, array.length-1);
		return array;
	}
	
	/**
	 * ��ӡ������Ϣ
	 * @param array
	 */
	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] / 10 <= 0) {
				System.out.print("0" + array[i] + " ");
			} else {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
	}
	
	/**
	 * ����ָ�������������������
	 * @param number  ����
	 * @param begin   ��С����
	 * @param end     �������
	 * @return
	 */
	public static int[] generateRandomArray(int number, int begin, int end) {
		
		int[] array = new int[number];
		int range = end - begin;
		
		for (int i = 0; i < number; i++) {
			array[i] = (int) (Math.random()*range + begin);
		}
		
		return array;
	}
	
	/**
	 * ������ɽ������������
	 * @param number     ����
	 * @param swapTimes  ��������
	 * @return
	 */
	public static int[] generateNearlyOrderArray(int number, int swapTimes) {
		
		int[] array = new int[number];
		
		for (int i = 0; i < number; i++) {
			array[i] = i;
		}
		
		for (int i = 0; i < swapTimes; i++) {
			int swapX = (int)(Math.random()*number);
			int swapY = (int)(Math.random()*number);
			
			int temp = array[swapX];
			array[swapX] = array[swapY];
			array[swapY] = temp;
		}
		
		return array;
	}
	
	/**
	 * ����һ������
	 * @param array
	 * @return
	 */
	public static int[] copyArray(int[] array) {
		
		int[] copyOf = Arrays.copyOf(array, array.length);
		return copyOf;
	}
	
	public void test(int a) {
		System.out.println("test reflect" + a);
	}

	public static void main(String[] args) {
		int[] test = { 49, 38, 65, 97, 76, 13, 27, 49, 55, 04 };
		print(test);
		int[] sort = insertionSort(test);
		print(sort);
	}

}
