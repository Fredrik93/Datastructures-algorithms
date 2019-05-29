//Assignment2_group33
import java.math.BigInteger;


public class Fibonacci {


    private static BigInteger[] fibMemo = new BigInteger[201];

    public static BigInteger fib(int n) {
        if (n==0) {
            return BigInteger.ZERO;
        }
        if(n <=1) {
            return BigInteger.ONE;
        }

        if(fibMemo[n] != null) {
            return fibMemo[n];
        }

        fibMemo[n] = fib(n - 1).add(fib(n - 2));
        return fibMemo[n];
    }


    public static void main(String[] args) {
        for (int i = 0; i < 201; i++) {
            System.out.println("{ (" + i + "), (" + fib(i) + ") }");
        }
    }

}
