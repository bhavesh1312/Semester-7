import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Item {
    double weight;
    double value;

    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Knapsack {
    public static double maximizeValue(Item[] items, double capacity) {
        Arrays.sort(items, Comparator.comparingDouble(item -> -item.value / item.weight));

        double totalValue = 0.0;
        for (Item item : items) {
            if (capacity <= 0) {
                break; // Knapsack is full
            }
            double fraction = Math.min(1, capacity / item.weight);
            totalValue += fraction * item.value;
            capacity -= fraction * item.weight;
        }

        return totalValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of items:- ");
        int n = Integer.parseInt(br.readLine());

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
        	System.out.print("Enter the value of item: " + (i + 1) + ": ");
            double value = Double.parseDouble(br.readLine());
            System.out.print("Enter the weight of item " + (i + 1) + ": ");
            double weight = Double.parseDouble(br.readLine());
            
            items[i] = new Item(weight, value);
        }

        System.out.print("Enter the maximum capacity of the knapsack: ");
        double capacity = Double.parseDouble(br.readLine());

        double maxValue = maximizeValue(items, capacity);

        System.out.println("Maximum value that can be obtained = " + maxValue);

        br.close();
    }
}
