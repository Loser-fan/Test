package parctice;

import java.util.LinkedList;
import java.util.List;

import parctice.util.list.MyLinkedList;

public abstract class T1 {

	public static void main(String[] args) {

		MyLinkedList<String> list = new MyLinkedList<>();
		list.addDate("qwe");
		list.addDate("we");
		list.addDate("sd");
		
		list.addDate("zhongjian", 3);
		list.print(list);
		
		
		System.out.println(list.size());
		
		
		
//		System.out.println(a);
	}

}
