package cracking.chap3;

import java.util.LinkedList;

public class AnimalQueue_Imp2 {

	LinkedList<Animal> cats;
	LinkedList<Animal> dogs;
	int order;

	public AnimalQueue_Imp2() {
		cats = new LinkedList<Animal>();
		dogs = new LinkedList<Animal>();
		order = 0;
	}

	public void enqueue(String animalType) {
		Animal animal = null;
		if (animalType.contains("cat")) {
			animal = new Cat(order);
			order++;
			cats.addLast(animal);
		} else {
			animal = new Dog(order);
			order++;
			dogs.addLast(animal);
		}
	}

	public Animal dequeueAny() {
		if (dogs.size() == 0) {
			return dequeueCats();
		} else if (cats.size() == 0) {
			return dequeueDogs();
		}

		Dog dog = (Dog) dogs.peek();
		Cat cat = (Cat) cats.peek();
		if (dog.isOlder(cat)) {
			return dequeueDogs();
		} else {
			return dequeueCats();
		}
	}

	public Animal dequeueCats() {
		return cats.poll();
	}

	public Animal dequeueDogs() {
		return dogs.poll();
	}
}
