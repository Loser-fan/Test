package algorithms;

import java.util.LinkedList;

import algorithms.heap.MaxHeap;

public class HeapTest {

	public static void main(String[] args) {
		
//		MaxHeap heap = new MaxHeap(10);
//		for (int i = 0; i < 10; i++) {
//			heap.insert((int)(Math.random()*100));
//		}
//		System.out.println(heap.toString());
//		heap.testPrint();
//		while (!heap.isEmpty()) {
//			System.out.print(heap.extractMax() + " ");
//		}
		
		int [] array = {13,25,38,72,22,46,95,87,95};
		MaxHeap heap = new MaxHeap(10);
		heap.insert(58);
		heap.addAll(array);
		System.out.println(heap.toString());
		heap.testPrint();
	}
}
