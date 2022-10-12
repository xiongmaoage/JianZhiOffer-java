package codeTop;

public class T121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = -1;
        for (int price : prices) {
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }
}
