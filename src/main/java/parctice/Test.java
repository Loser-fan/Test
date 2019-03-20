package parctice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import parctice.util.SortUtil;
import parctice.util.TestTimeUtil;

public class Test {

	private static Logger log = Logger.getLogger(Test.class);

	public static void main(String[] args) {
		SortUtil sUtil = new SortUtil();
		
		int[] test = {40,70,90,80,20,50,60,30};
		
		int number = 100000;
		int[] array1 = SortUtil.generateRandomArray(number, 0, number);
//		int[] array1 = SortUtil.generateNearlyOrderArray(number, 100);
		
		int[] array2 = SortUtil.copyArray(array1);
		int[] array3 = SortUtil.copyArray(array1);
		int[] array4 = SortUtil.copyArray(array1);
		int[] array5 = SortUtil.copyArray(array1);
		int[] array6 = SortUtil.copyArray(array1);
		int[] array7 = SortUtil.copyArray(array1);
		int[] array8 = SortUtil.copyArray(array1);
		int[] array9 = SortUtil.copyArray(array1);
		
//		
//		TestTimeUtil.testPerformance("ѡ������", sUtil.getClass(), "selectionSort", array1);
//		
//		//TestTimeUtil.testPerformance("��������", sUtil.getClass(), "insertionSort", array2);
//		
		TestTimeUtil.testPerformance("��������2.0", sUtil.getClass(), "insertionSort2", array3);
		
		//TestTimeUtil.testPerformance("ð������", sUtil.getClass(), "bubbleSort", array4);
		
		TestTimeUtil.testPerformance("ϣ������", sUtil.getClass(), "shellSort", array5);
		
		TestTimeUtil.testPerformance("�鲢�����Զ�����", sUtil.getClass(), "mergeSortUpDown", array6);
		
		TestTimeUtil.testPerformance("�鲢�����Ե�����", sUtil.getClass(), "mergeSortDownUp", array7);
		
		TestTimeUtil.testPerformance("��������", sUtil.getClass(), "quickSort", array8);
		
		TestTimeUtil.testPerformance("������", sUtil.getClass(), "heapSort", array9);

		
//		TestTimeUtil.testPerformance("��������", sUtil.getClass(), "quickSort", test);
//		SortUtil.print(test);

	}

}
