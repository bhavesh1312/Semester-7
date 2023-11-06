public class Fibonacci {
    public static void calculateFibonacciNonRecursive(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series with Non-Recursive approach: " + a + ", " + b);

        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(", " + c);
            a = b;
            b = c;
        }

        System.out.println();
    }

    public static int calculateFibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return calculateFibonacciRecursive(n - 1) + calculateFibonacciRecursive(n - 2);
    }

    public static void printFibonacciSeries(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(calculateFibonacciRecursive(i) + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of terms in the Fibonacci series: ");
        int n = Integer.parseInt(br.readLine());

        if (n < 0) {
            System.out.println("Invalid input. Please enter a non-negative integer.");
        } else {
            calculateFibonacciNonRecursive(n);
            System.out.print("Fibonacci Series with Recursive approach: ");
            printFibonacciSeries(n);
        }

        br.close();
    }
}
