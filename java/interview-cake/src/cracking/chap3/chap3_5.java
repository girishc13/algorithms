package cracking.chap3;

public class chap3_5 {

	public static void main(String[] args) throws Exception {
		MyQueue queue = new MyQueue();
		addItemsToQueue(queue);
		dequeueAllItems(queue);

		queue.enqueue(6);
		queue.enqueue(7);
		System.out.println("Dequeued item: " + queue.dequeue());
		System.out.println("Dequeued item: " + queue.dequeue());
		System.out.println("Dequeued item: " + queue.dequeue());
	}

	private static void dequeueAllItems(MyQueue queue) {
		System.out.println("Dequeued item: " + queue.dequeue());
		System.out.println("Dequeued item: " + queue.dequeue());
		System.out.println("Dequeued item: " + queue.dequeue());
		System.out.println("Dequeued item: " + queue.dequeue());
		System.out.println("Dequeued item: " + queue.dequeue());
		System.out.println("Dequeued item: " + queue.dequeue());
	}

	private static void addItemsToQueue(MyQueue queue) throws Exception {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
	}
}
