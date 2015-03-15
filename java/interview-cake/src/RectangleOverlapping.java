public class RectangleOverlapping {

	private static RectangleOverlapping recOverlapping;

	class Rectangle {

		public Rectangle(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}

		int x;
		int y;
		int width;
		int height;

		@Override
		public String toString() {
			return "x: " + x + ", y: " + y + ", width: " + width + ", height: "
					+ height;
		}
	}

	public static void main(String[] args) {
		recOverlapping = new RectangleOverlapping();
		Rectangle rec1 = recOverlapping.new Rectangle(8, 6, 4, 6);
		Rectangle rec2 = recOverlapping.new Rectangle(5, 2, 5, 7);
		if (doOverlap(rec1, rec2)) {
			System.out.println("Rectangles Overlap.");
		} else
			System.out.println("Rectangles don't overlap");
	}

	private static boolean doOverlap(Rectangle rec1, Rectangle rec2) {
		if ((rec1.x > (rec2.x + rec2.width))
				|| (rec2.x > (rec1.x + rec1.width)))
			return false;

		if (((rec1.y + rec1.height) < rec2.y)
				|| ((rec2.y + rec2.height) < rec1.y))
			return false;

		return true;
	}
}
