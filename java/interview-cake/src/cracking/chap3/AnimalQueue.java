package cracking.chap3;

import java.util.Iterator;
import java.util.LinkedList;

public class AnimalQueue {

	static LinkedList<Animal> list;

	class Animal {
		String type;

		public Animal(String type) {
			this.type = type;
		}
	}

	public AnimalQueue() {
		list = new LinkedList<AnimalQueue.Animal>();
	}

	public void enqueue(String animalType) {
		list.addLast(new Animal(animalType));
	}

	public Animal dequeueAny() {
		return list.removeFirst();
	}

	public Animal dequeueDog() {
		return dequeueAnimal("dog");
	}

	private Animal dequeueAnimal(String animalType) {
		for (Iterator<Animal> iterator = list.iterator(); iterator.hasNext();) {
			Animal animal = iterator.next();
			if (animal.type.contains(animalType)) {
				list.remove(animal);
				return animal;
			}
		}
		return null;
	}

	public Animal dequeueCat() {
		return dequeueAnimal("cat");
	}
}
