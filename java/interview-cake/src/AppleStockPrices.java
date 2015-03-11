public class AppleStockPrices {

	public static void main(String[] args) {
		int[] stock_prices = new int[500];
		double max_profit = 0;
		double min_price = 0;
		for (int index = 0; index < stock_prices.length; index++) {
			int cur_price = stock_prices[index];
			min_price = Math.min(min_price, cur_price);
			max_profit = Math.max(max_profit, cur_price - min_price);
		}
	}
}
