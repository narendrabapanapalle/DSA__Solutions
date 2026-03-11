import java.util.Scanner;

class PowerCalculator {
    public double myPow(double x, int n) {
        // Base case: any number to the power of 0 is 1
        if (n == 0 || x == 1.0) return 1; 
        
        long temp = n; // to avoid integer overflow
        
        // Handle negative exponents
        if (n < 0) {
            x = 1 / x;
            temp = -1L * n;
        }

        double ans = 1;

        for (long i = 0; i < temp; i++) {
            // Multiply ans by x for n times
            ans *= x; 
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double x = sc.nextDouble();  // base
        int n = sc.nextInt();        // exponent
        
        PowerCalculator obj = new PowerCalculator();
        System.out.printf("%.4f\n", obj.myPow(x, n));
        
        sc.close();
    }
}