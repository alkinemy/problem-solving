/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//first answer
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}

		StringBuilder serialized = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.remove();
			serialized.append(",");
			if (node == null) {
				serialized.append("n");
			} else {
				serialized.append(node.val);
				queue.add(node.left);
				queue.add(node.right);
			}
		}
		return serialized.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}

		String[] values = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(values[1]));
		Queue<TreeNode> queue = new LinkedList<>();
		int i = 2;
		queue.add(root);
		while (!queue.isEmpty() && i < values.length) {
			TreeNode node = queue.remove();
			String left = values[i++];
			if (!"n".equals(left)) {
				TreeNode leftNode = new TreeNode(Integer.parseInt(left));
				node.left = leftNode;
				queue.add(leftNode);
			}

			if (i == values.length) {
				break;
			}
			String right = values[i++];
			if (!"n".equals(right)) {
				TreeNode rightNode = new TreeNode(Integer.parseInt(right));
				node.right = rightNode;
				queue.add(rightNode);
			}
		}
		return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));





//second answer(remove unnecessary last nulls)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}

		StringBuilder serialized = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int nullCount = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                nullCount++;
            } else {
                serialized.append(",");
                for (int i = 0; i < nullCount; i++) {
                    serialized.append("n").append(",");
                }
                nullCount = 0;
                serialized.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
		return serialized.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}

		String[] values = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(values[1]));
		Queue<TreeNode> queue = new LinkedList<>();
		int i = 2;
		queue.add(root);
		while (!queue.isEmpty() && i < values.length) {
			TreeNode node = queue.remove();
			String left = values[i++];
			if (!"n".equals(left)) {
				TreeNode leftNode = new TreeNode(Integer.parseInt(left));
				node.left = leftNode;
				queue.add(leftNode);
			}

			if (i == values.length) {
				break;
			}
			String right = values[i++];
			if (!"n".equals(right)) {
				TreeNode rightNode = new TreeNode(Integer.parseInt(right));
				node.right = rightNode;
				queue.add(rightNode);
			}
		}
		return root;
    }
}
