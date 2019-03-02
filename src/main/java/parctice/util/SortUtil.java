package parctice.util;

import java.util.ArrayList;
import java.util.Arrays;

import parctice.util.mergeSort.MergeSort;
import parctice.util.quickSort.QuickSort;
import sun.font.CreatedFontTracker;

public class SortUtil {
	/**
	 * 希尔排序  Shell Sort  在有序序列中使用插入排序移动方法
	 * 插入排序移动方法 请查看 Insertion Sort 2.0
	 * @param array
	 * @return
	 */
	public static int[] shellSort(int[] array) {

		int length = array.length;
		int tk;    //增量
		for (tk = length / 2; tk > 0; tk /= 2) {
			
			for (int i = tk; i < length; i++) {
				
				//使用插入排序移动方法
				int j = i;
				int temp = array[j];
				for (j = i; j - tk >= 0; j -= tk) {
					if (temp < array[j - tk]) {
						array[j] = array[j - tk];
					} else
						break;
				}
				array[j] = temp;
				
//				//使用插入排序插入法
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
	 * 直接排序
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
	 * 冒泡排序 Bubble Sort
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
	 * 选择排序 Selection sort
	 * @param array
	 * @return
	 */
	public static int[] selectionSort(int[] array) {

		int length = array.length;
		for (int i = 0; i < length; i++) {
			int index = i; // 最小的数位置
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
	 * 插入排序 insertionSort
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
	 * method verion 2.0  优化过
	 * 插入排序 insertionSort
	 * @param array
	 * @return
	 */
	public static int[] insertionSort2(int[] array) {
		
		int length = array.length;
		for (int i = 1; i < length; i++) {
			
			int j = i;
			//寻找temp适合插入的位置j
			int temp = array[j];
			for (j = i; j > 0 && temp < array[j-1]; j--) {
				array[j] = array[j-1];
			}
			array[j] = temp;   
		} 
		return array;
	}
	
	/**
	 * 归并排序  Merge Sort 自顶向下方式
	 * @param array
	 * @return
	 */
	public static int[] mergeSortUpDown(int[] array) {
		
		int length = array.length;
		
		MergeSort.mergeSortUpDown(array, 0, length - 1);
		return array;
	}
	
	/**
	 * 归并排序  Merge Sort 自底向上方式
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
	 * 打印数组信息
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
	 * 产生指定个数的随机整数数组
	 * @param number  个数
	 * @param begin   最小数字
	 * @param end     最大数字
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
	 * 随机生成近乎有序的数组
	 * @param number     个数
	 * @param swapTimes  交换次数
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
	 * 复制一份数组
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
