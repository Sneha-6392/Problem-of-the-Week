import java.util.*;
public class Solution {
    public static int minPaintCost(int n, int k, int[][] costs) {
        if (n == 0 || k == 0) return 0;

        int[] dp = Arrays.copyOf(costs[0], k);

        for (int i = 1; i < n; i++) {
            int[] newDp = new int[k];
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int idx1 = -1;
            int idx2 = -1;
            for (int c = 0; c < k; c++) {
                if (dp[c] < min1) {
                    min2 = min1;
                    idx2 = idx1;
                    min1 = dp[c];
                    idx1 = c;
                } else if (dp[c] < min2) {
                    min2 = dp[c];
                    idx2 = c;
                }
            }
            for (int j = 0; j < k; j++) {
                if (j == idx1) {
                    newDp[j] = costs[i][j] + min2;
                } else {
                    newDp[j] = costs[i][j] + min1;
                }
            }
            dp = newDp;
        }
        int minCost = Integer.MAX_VALUE;
        for (int cost : dp) {
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] costs = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                costs[i][j] = sc.nextInt();
            }
        }
        System.out.println(minPaintCost(n, k, costs));
        sc.close();
    }
}
