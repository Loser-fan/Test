package algorithms.tree;

public class BinaryTreeNode {

	String key;
	String value;
	BinaryTreeNode leftNode;
	BinaryTreeNode rightNode;
	
	public BinaryTreeNode(String key, String value) {
		this.key = key;
		this.value = value;
		this.leftNode = null;
		this.rightNode = null;
	}
}
