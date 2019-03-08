/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
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
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ordered = inOrder(root);
        int start = 0;
        int end = ordered.size() - 1;
        while (start < end) {
            int sum = ordered.get(start) + ordered.get(end);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    public List<Integer> inOrder(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> before = inOrder(node.left);
        List<Integer> after = inOrder(node.right);

        List<Integer> result = new ArrayList<>();
        result.addAll(before);
        result.add(node.val);
        result.addAll(after);
        return result;
    }
}


//second answer(cheated)
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> valueSet = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (valueSet.contains(k - node.val)) {
                return true;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            valueSet.add(node.val);
        }
        return false;
    }

}
