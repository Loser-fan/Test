package algorithms.heap;

public class MaxHeap {
	
	private int[] date;
	private int count;
	private int capacity;
	
	/**
	 * 创建最大堆
	 * @param capacity 堆大小
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) {
		date = new int[capacity+1];
		this.capacity = capacity;
		count = 0;
	}
	
	/**
	 * 添加数据到堆队列中（最大堆）
	 */
	public void insert(int date1) {
		assert count + 1 <= capacity : "新增失败，已经超出数组范围";
		date[count + 1] = date1;
		count++;
		
		shiftUp(count);
	}
	
	public int extractMax() {
		assert count > 0: "当前堆没有数据";
		int max = date[1];
		
		date[1] = date[count];
		count--;
		shiftDown(1);
		
		
		return max;
	}
	
	public int[] addAll(int[] array) {
		
		assert array.length + count <= capacity : "addAll进去的元素已经超过堆的容量";
		
		
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
	 * 判断当前位置是否需要上移
	 * @param index 
	 */
	private void shiftUp(int index) {
		
		while(index > 1 && date[index/2] < date[index]) { //k=1 已经是根节点了，所以大于1
			int temp = date[index/2];
			date[index/2] = date[index];
			date[index] = temp;
			index /= 2;
		}
	}
	
	/**
	 * 对移除了最大元素的树进行重新  排序 （最大堆）
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
