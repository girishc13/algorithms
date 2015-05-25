package cracking.chap3;

public class chap3_8_Imp2 {

	public static void main(String[] args) {
		AnimalQueue_Imp2 queue = createNewQueue();

		System.out.println("Dequeue Any: " + queue.dequeueAny().type);
		System.out.println("DequeueDog: " + queue.dequeueDogs().type);
		System.out.println("Dequeue Any: " + queue.dequeueAny().type);
		System.out.println("Dequeue Any: " + queue.dequeueCats().type);
		System.out.println("Dequeue Any: " + queue.dequeueCats().type);
		System.out.println("Dequeue Any: " + queue.dequeueAny().type);
	}

	private static AnimalQueue_Imp2 createNewQueue() {
		AnimalQueue_Imp2 queue = new AnimalQueue_Imp2();
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
