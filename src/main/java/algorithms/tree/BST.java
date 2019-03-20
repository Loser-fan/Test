package algorithms.tree;

public class BST {
	
	private BinaryTreeNode root;
	
	private int count;
	
	public BST() {
		this.root = null;
		this.count = 0;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean contain(String key) {
		BinaryTreeNode temp = root;
		while(true) {
			if (temp == null) {
				return false;
			}
			
			if (key.compareTo(temp.key) > 0) {
				temp = temp.rightNode;
			} else if (key.compareTo(temp.key) < 0) {
				temp = temp.leftNode;
			} else {
				return true;
			}
		}
	}
	
	public void insert (String key, String value) {
		BinaryTreeNode temp = root;
		
		while (true) {
			if (temp == null) {
				
			}
		}
	}

}
