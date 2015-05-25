package cracking.chap3;

public class Dog extends Animal {

	public Dog(int order) {
		type = "dog";
		this.order = order;
	}

	public boolean isOlder(Animal animal) {
		return this.order < animal.order;
	}
}
