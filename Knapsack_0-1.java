import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack {
    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of items: ");
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the value of item " + (i + 1) + ": ");
            values[i] = Integer.parseInt(br.readLine());
            System.out.print("Enter the weight of item " + (i + 1) + ": ");
            weights[i] = Integer.parseInt(br.readLine());
        }

        System.out.print("Enter the maximum capacity of the knapsack: ");
        int capacity = Integer.parseInt(br.readLine());

        int maxValue = knapsack(values, weights, capacity);

        System.out.println("Maximum value that can be obtained = " + maxValue);

        br.close();
    }
}

