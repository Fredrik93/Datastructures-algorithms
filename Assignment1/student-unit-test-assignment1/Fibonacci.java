import java.math.BigInteger;

public class Fibonacci {
  // A naive implementation
  public static BigInteger fib(int n) {
    if (n <= 1)
      return BigInteger.ONE;
    return fib(n - 1).add(fib(n - 2));
  }

  public static void main(String[] args) {
    for (int i = 0; i < 201; i++) {
      System.out.println("{ (" + i + "), (" + fib(i) + ") }");
    }
  }

}
