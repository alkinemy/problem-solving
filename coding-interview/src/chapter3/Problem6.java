
interface Animal {
}

class Dog implements Animal {
}

class Cat implements Animal {
}

class AnimalShelter {
	private final Queue<Dog> dogs = new LinkedList<>();
	private final Queue<Cat> cats = new LinkedList<>();

	public void enqueue(Animal animal) {
		if (animal instanceof Dog) {
			dogs.add((Dog)animal);
		} else if (animal instanceof Cat) {
			cats.add((Cat)animal);
		} else {
			throw new IllegalArgumentException("Unknown animal");
		}
	}

	public Dog dequeueDog() {
		return dogs.remove();
	}

	public Cat dequeueCat() {
		return cats.remove();
	}

	public Animal dequeueAny() {
		if (dogs.isEmpty() && cats.isEmpty()) {
			throw new NoAnimalInShelterException();
		}
		long time = System.currentTimeMillis();
		long direction = time % 2;
		if (direction == 0) {// dog
			if (dogs.isEmpty()) {
				return cats.remove();
			} else {
				return dogs.remove();
			}
		} else { //cat
			if (cats.isEmpty()) {
				return dogs.remove();
			} else {
				return cats.remove();
			}
		}
	}

}
