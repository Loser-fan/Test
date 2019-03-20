package algorithms.heap;

public class MaxHeap {
	
	private int[] date;
	private int count;
	private int capacity;
	
	/**
	 * ��������
	 * @param capacity �Ѵ�С
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) {
		date = new int[capacity+1];
		this.capacity = capacity;
		count = 0;
	}
	
	/**
	 * ������ݵ��Ѷ����У����ѣ�
	 */
	public void insert(int date1) {
		assert count + 1 <= capacity : "����ʧ�ܣ��Ѿ��������鷶Χ";
		date[count + 1] = date1;
		count++;
		
		shiftUp(count);
	}
	
	public int extractMax() {
		assert count > 0: "��ǰ��û������";
		int max = date[1];
		
		date[1] = date[count];
		count--;
		shiftDown(1);
		
		
		return max;
	}
	
	public int[] addAll(int[] array) {
		
		assert array.length + count <= capacity : "addAll��ȥ��Ԫ���Ѿ������ѵ�����";
		
		
		for (int i = 1; i <= array.length; i++) {
			date[count + i] = array[i - 1];
		}
		count = count + array.length;
		
		for (int index = count/2; index > 0; index--) {
			shiftDown(index);
		}
		
		return date;
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= count; i++) {
			sb.append(date[i] + " ");
		}
		return sb.toString(); 
	}
	
	public void testPrint() {
		for (int i = 1; i <= count; i *= 2) {
			for (int j = i; j < i + i && j <= count; j++) {
				System.out.print(date[j] + "\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * �жϵ�ǰλ���Ƿ���Ҫ����
	 * @param index 
	 */
	private void shiftUp(int index) {
		
		while(index > 1 && date[index/2] < date[index]) { //k=1 �Ѿ��Ǹ��ڵ��ˣ����Դ���1
			int temp = date[index/2];
			date[index/2] = date[index];
			date[index] = temp;
			index /= 2;
		}
	}
	
	/**
	 * ���Ƴ������Ԫ�ص�����������  ���� �����ѣ�
	 */
	private void shiftDown(int index) {
		if (2*index > count)
			return;
		
		int changeIndex = 2*index;
		int changeValue = date[index];
		while (2*index <= count) {
			
			changeIndex = 2*index;
			if (index*2 + 1 <= count && date[2*index] < date[2*index + 1]) {
				changeIndex = 2*index + 1;
			}
			if (changeValue >= date[changeIndex])
				break;

			date[index] = date[changeIndex];
			index = changeIndex;
			
		}
		
		date[index] = changeValue;
//		int temp = date[changeIndex];
//		date[changeIndex] = date[index];
//		date[index] = temp;
	}

}
