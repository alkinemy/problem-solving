/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

	private List<TreeNode> inOrder = new ArrayList<>();
	private int currentIndex;

	public BSTIterator(TreeNode root) {
		inOrder(root);
		this.currentIndex = -1;
	}

	private void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		inOrder.add(node);
		inOrder(node.right);
	}

	/** @return the next smallest number */
	public int next() {
		return inOrder.get(++currentIndex).val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return currentIndex + 1 < inOrder.size();
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

//solution(stack)
class BSTIterator {

	private Stack<TreeNode> nodes = new Stack<>();

	public BSTIterator(TreeNode root) {
		TreeNode current = root;
		while(current != null) {
			nodes.push(current);
			current = current.left;
		}
	}

	public int next() {
		TreeNode node = nodes.pop();
		TreeNode current = node.right;
		while(current != null) {
			stack.push(current);
			current = current.left;
		}
		return node.val;
	}

	public boolean hasNext() {
		return !nodes.isEmpty();
	}

}


//solution(node)
class BSTIterator {

	private TreeNode node;
	
	public BSTIterator(TreeNode root) {
		this.node = root;
	}

	public int next() {
		while (node.left != null) {
			TreeNode current = node.left;
			while(current.right != null && current.right != node) {
				current = current.right;
			}
			if (current.right == node) {
				current.right = null;
				break;
			}
			current.right = node;
			node = node.left;
		}
		int value = node.val;
		node = node.right;
		return value; 
	}

	public boolean hasNext() {
		return node != null;
	}

}
