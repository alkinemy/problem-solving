class Box {
    int widgh;
    int depth;
    int height;
}

int getMaxHeight(List<Box> boxes) {
    boxes.sort((b1, b2) -> b2.height - b1.height);

    int maxHeight = 0;
	int[] maxHeightsCache = new int[boxes.size()];
    for (int i = 0; i < boxes.size(); i++) {
        int height = getMaxHeight(boxes, i, maxHeightsCache);
        if (height > maxHeight) {
            maxHeight = height;
        }
    }
    return maxHeight;
}

int getMaxHeight(List<Box> boxes, int bottomIndex, int[] maxHeightsCache) {
    Box bottom = boxes.get(bottomIndex);
	if (maxHeightsCache[bottomIndex] != 0) {
		return maxHeightsCache[bottomIndex];
	}

    int maxHeight = bottom.height;
    for (int i = bottomIndex + 1; i < boxes.size(); i++) {
        Box box = boxes.get(i);
        if (canPile(bottom, box)) {
            int height = getMaxHeight(boxes, i, maxHeightsCache) + bottom.height;
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
    }
	maxHeightsCache[bottomIndex] = maxHeight;
    return maxHeight;
}

boolean canPile(Box bottom, Box above) {
    return (bottom.width > above.width) && (bottom.depth > above.depth) && (bottom.height > above.height);
}
