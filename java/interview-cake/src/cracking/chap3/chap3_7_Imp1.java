package cracking.chap3;

public class chap3_7_Imp1 {

	public static void main(String[] args) {
		AnimalQueue queue = createQueue();

		System.out.println("Dequeue Any: " + queue.dequeueAny().type);
		System.out.println("DequeueDog: " + queue.dequeueDog().type);
		System.out.println("Dequeue Any: " + queue.dequeueAny().type);
		System.out.println("Dequeue Any: " + queue.dequeueCat().type);
		System.out.println("Dequeue Any: " + queue.dequeueCat().type);
		System.out.println("Dequeue Any: " + queue.dequeueAny().type);
	}

	private static AnimalQueue createQueue() {
		AnimalQueue queue = new AnimalQueue();

		queue.enqueue("cat1");
		queue.enqueue("dog1");
		queue.enqueue("dog2");
		queue.enqueue("cat2");
		queue.enqueue("dog3");
		queue.enqueue("cat3");
		queue.enqueue("dog4");
		return queue;
	}

}
