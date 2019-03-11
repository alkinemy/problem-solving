/**
 * https://leetcode.com/problems/find-anagram-mappings/
 */

class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
		if (A == null || B == null || A.length != B.length) {
			return null;
		}

		Map<Integer, Queue<Integer>> indices = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			Queue<Integer> index = indices.getOrDefault(B[i], new LinkedList<>());
			index.add(i);
			indices.put(B[i], index);
		}

		int[] result = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int aValue = A[i];
			if (indices.containsKey(aValue)) {
				Queue<Integer> index = indices.get(aValue);
				int bIndex = index.remove();
				result[i] = bIndex;
				if (index.isEmpty()) {
					indices.remove(aValue);
				} else {
					indices.put(aValue, index);
				}
			} else {
				return null;
			}
		}
		return result;
    }
}
