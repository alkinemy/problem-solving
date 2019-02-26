
List<List<Integer>> findAllSubsets(List<Integer> set) {
	List<List<Integer>> result = new ArrayList<>();
	int max = 1 << set.size();
	for (int i = 0; i < max; i++) {
		List<Integer> subset = createSubset(set, i);
		result.add(subset);
	}
	return result;
}

List<Integer> createSubset(List<Integer> set, int pivot) {
	List<Integer> result = new ArrayList<>();
	for (int i = 0; i < set.size(); i++) {
		int mask = 1 << i;
		if ((pivot & mask) > 0) {
			result.add(set.get(i));
		}
	}
	return result;
}
