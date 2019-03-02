package parctice.util.list;


public class MyLinkedList<T> {
	
	private Node<T> head = null;
	
	public MyLinkedList() {
		
	}
	
	/**
	 * 添加链表数据，在链表的末尾添加
	 * @param date
	 */
	public void addDate(T date) {
		
		if (head == null) {
			head = new Node<T>(date);
			return;
		}
		
		Node<T> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = new Node<T>(date);
		
	}
	
	public void addDate(T date, int index) {
		
		if (head == null) {
			head = new Node<T>(date);
			return;
		}
		
		Node<T> temp = head;
		Node<T> addNode = new Node<T>(date);
		int i = 0;
		while (temp.next != null) {
			
			if (i == index) {
				Node<T> next = temp.next;
				temp.next = addNode;
				addNode.next = next;
				break;
			}
			i++;
		}
	}
	
	public int size() {
		
		if (head == null)
			return 0;
		int size = 1;
		Node<T> temp = head;
		while(temp.next != null) {
			temp = temp.next;
			size ++;
		}
	
		return size;
	}
	
	
	public void print(MyLinkedList<T> list) {
		if (list.head == null) {
			System.out.println("null");
		}
		Node<T> temp = head;
		while (temp != null) {
			System.out.println(temp.date);
			temp = temp.next;
		}
	}

}

class Node<T> {
	Node<T> next = null;
	T date;
	public Node(T date) {
		this.date = date;
	}
}
