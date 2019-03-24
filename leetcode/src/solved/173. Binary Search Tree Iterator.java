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
