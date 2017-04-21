public class Fibonacci{
  private static GinormousInt fib1  = new GinormousInt("0");
  private static GinormousInt fib2  = GinormousInt.ZERO;
  private static GinormousInt fib3  = GinormousInt.ONE;

  public static GinormousInt fibonacci(int number) {
    if (number == 0 || number == 1) {
      return GinormousInt.ONE;
    } else {
    for (int i = 1; i < number; i ++) {
      fib1 = fib2.addInt(fib3);
      fib2 = fib3;
      fib3 = fib1;
    }
  }
    return fib1;
  }

  public static void main( String args[] ) {
    // Fibonacci fibonacci = new Fibonacci();
    System.out.println(fibonacci(Integer.parseInt(args[0])));
  }
}
