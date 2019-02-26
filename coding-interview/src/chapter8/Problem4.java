

Set<Set<String>> findAllSubsets(String[] elements) {
	return findAllSubsets(elements, elements.length - 1);
}

Set<Set<String>> findAllSubsets(String[] elements, int end) {
	if (end == -1) {
		Set<Set<String>> subsets = new HashSet<>();
		subsets.add(new HashSet<>());
		return subsets;
	}
	Set<Set<String>> subsets = findAllSubsets(elements, end - 1);
	Set<Set<String>> newSubsets = new HashSet<>(subsets);
	for (Set<String> subset : subsets) {
		Set<String> newSubset = new HashSet<>(subset);
		newSubset.add(elements[end]);
		newSubsets.add(newSubset);
	}
	return newSubsets;
}
